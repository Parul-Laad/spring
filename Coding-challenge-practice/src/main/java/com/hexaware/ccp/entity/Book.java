package com.hexaware.ccp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Book {
    @Id
    private int isbn;

    @NotBlank(message = "Title cannot be null")
    private String title;

    @NotBlank(message = "Author cannot be null")
    private String author;

    @Min(value = 1900, message = "Invalid publication year")
    private int publicationYear;

    private String genre;

    @Min(value = 0, message = "Number of copies cannot be negative")
    private int numberOfCopies;

	
   public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getPublicationYear() {
		return publicationYear;
	}


	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getNumberOfCopies() {
		return numberOfCopies;
	}


	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}


    @Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
				+ ", genre=" + genre + ", numberOfCopies=" + numberOfCopies + "]";
	}


    

    
    public Book(int isbn, @NotBlank(message = "Title cannot be null") String title,
			@NotBlank(message = "Author cannot be null") String author,
			@Min(value = 1900, message = "Invalid publication year") int publicationYear, String genre,
			@Min(value = 0, message = "Number of copies cannot be negative") int numberOfCopies) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.genre = genre;
		this.numberOfCopies = numberOfCopies;
	}

	public Book() {
	   
    }
}

