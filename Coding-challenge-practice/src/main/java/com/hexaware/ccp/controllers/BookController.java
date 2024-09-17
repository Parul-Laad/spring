package com.hexaware.ccp.controllers;

import com.hexaware.ccp.dto.BookDTO;
import com.hexaware.ccp.entity.Book;
import com.hexaware.ccp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addbook")
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookDTO) {
        Book book = bookService.convertToEntity(bookDTO);
        Book newBook = bookService.addBook(book);
        BookDTO newBookDTO = bookService.convertToDTO(newBook);
        return new ResponseEntity<>(newBookDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getallbooks")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<BookDTO> bookDTOs = books.stream()
            .map(bookService::convertToDTO)
            .toList();
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

    @GetMapping("/getbookbyisbn/{isbn}")
    public ResponseEntity<BookDTO> getBookByIsbn(@PathVariable int isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        BookDTO bookDTO = bookService.convertToDTO(book);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @PutMapping("/updatebookbyisbn/{isbn}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int isbn, @Valid @RequestBody BookDTO bookDTO) {
        Book book = bookService.convertToEntity(bookDTO);
        Book updatedBook = bookService.updateBook(isbn, book);
        BookDTO updatedBookDTO = bookService.convertToDTO(updatedBook);
        return new ResponseEntity<>(updatedBookDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deletebookbyisbn/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable int isbn) {
        bookService.deleteBook(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/issuebookbyisbn/{isbn}")
    public ResponseEntity<Void> issueBook(@PathVariable int isbn) {
        bookService.issueBook(isbn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/returnbookbyisbn/{isbn}")
    public ResponseEntity<Void> returnBook(@PathVariable int isbn) {
        bookService.returnBook(isbn);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}














//package com.hexaware.ccp.controllers;
//
//import com.hexaware.ccp.dto.BookDTO;
//import com.hexaware.ccp.entity.Book;
//import com.hexaware.ccp.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import jakarta.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class BookController {
//
//    @Autowired
//    private BookService bookService;
//
//    @PostMapping("/addbook")
//    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookDTO) {
//        Book book = bookService.convertToEntity(bookDTO);
//        Book newBook = bookService.addBook(book);
//        BookDTO newBookDTO = bookService.convertToDTO(newBook);
//        return new ResponseEntity<>(newBookDTO, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/getallbooks")
//    public ResponseEntity<List<BookDTO>> getAllBooks() {
//        List<Book> books = bookService.getAllBooks();
//        List<BookDTO> bookDTOs = new ArrayList<>();
//        for (Book book : books) {
//            bookDTOs.add(bookService.convertToDTO(book));
//        }
//        if (bookDTOs.isEmpty()) {
//            return new ResponseEntity<>(bookDTOs, HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
//        }
//    }
//
//    @GetMapping("/getbookbyisbn/{isbn}")
//    public ResponseEntity<BookDTO> getBookByIsbn(@PathVariable int isbn) {
//        Book book = bookService.getBookByIsbn(isbn);
//        BookDTO bookDTO = bookService.convertToDTO(book);
//        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
//    }
//
//    @PutMapping("/updatebookbyisbn/{isbn}")
//    public ResponseEntity<BookDTO> updateBook(@PathVariable int isbn, @Valid @RequestBody BookDTO bookDTO) {
//        Book bookDetails = bookService.convertToEntity(bookDTO);
//        Book updatedBook = bookService.updateBook(isbn, bookDetails);
//        BookDTO updatedBookDTO = bookService.convertToDTO(updatedBook);
//        return new ResponseEntity<>(updatedBookDTO, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/deletebookbyisbn/{isbn}")
//    public ResponseEntity<String> deleteBook(@PathVariable int isbn) {
//        bookService.deleteBook(isbn);
//        return new ResponseEntity<>("Book deleted successfully.", HttpStatus.OK);
//    }
//
//    @PostMapping("/issuebookbyisbn/{isbn}")
//    public ResponseEntity<String> issueBook(@PathVariable int isbn) {
//        bookService.issueBook(isbn);
//        return new ResponseEntity<>("Book issued successfully.", HttpStatus.OK);
//    }
//
//    @PostMapping("/returnbookbyisbn/{isbn}")
//    public ResponseEntity<String> returnBook(@PathVariable int isbn) {
//        bookService.returnBook(isbn);
//        return new ResponseEntity<>("Book returned successfully.", HttpStatus.OK);
//    }
//}















//package com.hexaware.ccp.controllers;
//
//import com.hexaware.ccp.entity.Book;
//import com.hexaware.ccp.service.BookService;
//import com.hexaware.ccp.exceptions.BookNotFoundException;
//import com.hexaware.ccp.exceptions.BookAlreadyExistsException;
//import com.hexaware.ccp.exceptions.InvalidBookOperationException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import jakarta.validation.Valid;
//import java.util.List;
//
//@RestController
//
//public class BookController {
//
//    @Autowired
//    private BookService bookService;
//
//    @PostMapping("/addbook")
//    public ResponseEntity<?> addBook(@Valid @RequestBody Book book) {
//        try {
//            
//            if (bookService.bookExists(book.getIsbn())) {
//                throw new BookAlreadyExistsException("Book with ISBN " + book.getIsbn() + " already exists.");
//            }
//            Book newBook = bookService.addBook(book);
//            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
//        } catch (BookAlreadyExistsException e) {
//        	return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    
//    
//    
//    @GetMapping("/getallbooks")
//    public ResponseEntity<Object> getAllBooks() {
//        List<Book> books = bookService.getAllBooks();
//        if (books.isEmpty()) {
//            return new ResponseEntity<>("No books found.", HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(books, HttpStatus.OK);
//        }
//    }
//
//    @GetMapping("/getbookbyisbn/{isbn}")
//    public ResponseEntity<?> getBookByIsbn(@PathVariable int isbn) {
//        try {
//            if (!bookService.bookExists(isbn)) {
//                throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
//            }
//            Book book = bookService.getBookByIsbn(isbn);
//            return new ResponseEntity<>(book, HttpStatus.OK);
//        } catch (BookNotFoundException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>("An internal server error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/updatebookbyisbn/{isbn}")
//    public ResponseEntity<?> updateBook(@PathVariable int isbn, @Valid @RequestBody Book bookDetails) {
//        try {
//            if (!bookService.bookExists(isbn)) {
//                throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
//            }
//            Book updatedBook = bookService.updateBook(isbn, bookDetails);
//            return new ResponseEntity<>("Book updated successfully: " , HttpStatus.OK);
//        } catch (BookNotFoundException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>("An internal server error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/deletebookbyisbn/{isbn}")
//    public ResponseEntity<String> deleteBook(@PathVariable int isbn) {
//        try {
//            if (!bookService.bookExists(isbn)) {
//                throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
//            }
//            bookService.deleteBook(isbn);
//            return new ResponseEntity<>("Book deleted successfully.", HttpStatus.OK);
//        } catch (BookNotFoundException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>("An internal server error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/issuebookbyisbn/{isbn}")
//    public ResponseEntity<String> issueBook(@PathVariable int isbn) {
//        try {
//            if (!bookService.bookExists(isbn)) {
//                throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
//            }
//            bookService.issueBook(isbn);
//            return new ResponseEntity<>("Book issued successfully.", HttpStatus.OK);
//        } catch (BookNotFoundException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        } catch (InvalidBookOperationException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>("An internal server error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/returnbookbyisbn/{isbn}")
//    public ResponseEntity<String> returnBook(@PathVariable int isbn) {
//        try {
//            if (!bookService.bookExists(isbn)) {
//                throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
//            }
//            bookService.returnBook(isbn);
//            return new ResponseEntity<>("Book returned successfully.", HttpStatus.OK);
//        } catch (BookNotFoundException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        } catch (InvalidBookOperationException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>("An internal server error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
//
//
