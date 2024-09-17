package com.hexaware.ccp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleBookNotFoundException(BookNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                "BOOK_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleBookAlreadyExistsException(BookAlreadyExistsException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                "BOOK_ALREADY_EXISTS"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidBookOperationException.class)
    public ResponseEntity<ErrorDetails> handleInvalidBookOperationException(InvalidBookOperationException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                "INVALID_BOOK_OPERATION"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                "An internal server error occurred.",
                request.getDescription(false),
                "INTERNAL_SERVER_ERROR"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
