package com.hexaware.ccp.exceptions;


public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String message) {
        super(message);
    }
}
