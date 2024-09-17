package com.hexaware.ccp.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.ccp.dao.BookRepository;
import com.hexaware.ccp.entity.Book;

@SpringBootTest
public class BookRepoJpaMethodTest {
	
	    @Autowired
	    private BookRepository bookRepository;

	   
	    @Test
	    void saveBookTest() {
	        Book book = new Book(102, "Java Book", "Yashavant Kanetkar", 2022, "Technical", 5);
	        bookRepository.save(book);
	    }
	    
	    @Test
	    void findByIsbnTest() {
	        Book book = bookRepository.findById(102).orElse(null);
	        System.out.println( book);
	    }

	    
	    @Test
	    void findAllBooksTest() {
	        List<Book> books = (List<Book>) bookRepository.findAll();
	        for (Book book : books) {
	            System.out.println(book);
	        }
	    }

	    
	    @Test
	    void updateBookTitleTest() {
	        Book book = bookRepository.findById(103).orElse(null);
	        if (book != null) {
	            book.setTitle("Updated Title");
	            bookRepository.save(book);
	            System.out.println(book);
	        } else {
	            System.out.println("Book not found.");
	        }
	    }

	    
	    @Test
	    void deleteBookTest() {
	        Book book = bookRepository.findById(103).orElse(null);
	        if (book != null) {
	            bookRepository.delete(book);
	            System.out.println("Deleted book: " + book);
	        } else {
	            System.out.println("Book not found.");
	        }
	    }
}