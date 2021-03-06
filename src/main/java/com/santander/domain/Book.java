package com.santander.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String bookTitle;
	@Size(min = 4, max = 20)
	private String genre;
	private String yearPublished;

	public Book() {

	}

	public Book(String bookTitle, String genre, String yearPublished) {
		this.bookTitle = bookTitle;
		this.genre = genre;
		this.yearPublished = yearPublished;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}

	public Long getId(Long id) {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}