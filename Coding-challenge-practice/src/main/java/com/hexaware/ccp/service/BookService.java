package com.hexaware.ccp.service;

import com.hexaware.ccp.dao.BookRepository;
import com.hexaware.ccp.dto.BookDTO;
import com.hexaware.ccp.entity.Book;
import com.hexaware.ccp.exceptions.BookNotFoundException;
import com.hexaware.ccp.exceptions.InvalidBookOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByIsbn(int isbn) {
        return bookRepository.findById(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book with ISBN " + isbn + " not found."));
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(int isbn, Book bookDetails) {
        Book book = getBookByIsbn(isbn);
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublicationYear(bookDetails.getPublicationYear());
        book.setGenre(bookDetails.getGenre());
        book.setNumberOfCopies(bookDetails.getNumberOfCopies());
        return bookRepository.save(book);
    }

    public void deleteBook(int isbn) {
        Book book = getBookByIsbn(isbn);
        bookRepository.delete(book);
    }

    public void issueBook(int isbn) {
        Book book = getBookByIsbn(isbn);
        if (book.getNumberOfCopies() > 0) {
            book.setNumberOfCopies(book.getNumberOfCopies() - 1);
            bookRepository.save(book);
        } else {
            throw new InvalidBookOperationException("No copies available for ISBN: " + isbn);
        }
    }

    public void returnBook(int isbn) {
        Book book = getBookByIsbn(isbn);
        book.setNumberOfCopies(book.getNumberOfCopies() + 1);
        bookRepository.save(book);
    }

    // Convert DTO to Entity
    public Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setGenre(bookDTO.getGenre());
        book.setNumberOfCopies(bookDTO.getNumberOfCopies());
        return book;
    }

    // Convert Entity to DTO
    public BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPublicationYear(book.getPublicationYear());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setNumberOfCopies(book.getNumberOfCopies());
        return bookDTO;
    }
}












//package com.hexaware.ccp.service;
//
//
//import com.hexaware.ccp.dao.BookRepository;
//import com.hexaware.ccp.entity.Book;
//import com.hexaware.ccp.exceptions.BookNotFoundException;
//import com.hexaware.ccp.exceptions.InvalidBookOperationException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class BookService {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    public List<Book> getAllBooks() {
//        return bookRepository.findAll();
//    }
//
//    
//    public boolean bookExists(int isbn) {
//        return bookRepository.existsById(isbn);
//    }
//    
//    
//    public Book getBookByIsbn(int isbn) {
//        return bookRepository.findById(isbn)
//                .orElseThrow(() -> new BookNotFoundException("Book with ISBN " + isbn + " not found."));
//    }
//
//    public Book addBook(Book book) {
//        return bookRepository.save(book);
//    }
//
//    public Book updateBook(int isbn, Book bookDetails) {
//        Book book = getBookByIsbn(isbn);
//        book.setTitle(bookDetails.getTitle());
//        book.setAuthor(bookDetails.getAuthor());
//        book.setPublicationYear(bookDetails.getPublicationYear());
//        book.setGenre(bookDetails.getGenre());
//        book.setNumberOfCopies(bookDetails.getNumberOfCopies());
//        return bookRepository.save(book);
//    }
//
//    public void deleteBook(int isbn) {
//        Book book = getBookByIsbn(isbn);
//        bookRepository.delete(book);
//    }
//
//    public void issueBook(int isbn) {
//        Book book = getBookByIsbn(isbn);
//        if (book.getNumberOfCopies() > 0) {
//            book.setNumberOfCopies(book.getNumberOfCopies() - 1);
//            bookRepository.save(book);
//        } else {
//            throw new InvalidBookOperationException("No copies available for ISBN: " + isbn);
//        }
//    }
//
//    public void returnBook(int isbn) {
//        Book book = getBookByIsbn(isbn);
//        book.setNumberOfCopies(book.getNumberOfCopies() + 1);
//        bookRepository.save(book);
//    }
//}
