package com.lejap59.booklibrary;

public class Book {

    private final String title;
    private final String author;
    private final Integer ISBN;

    public Book (String title, String author, Integer ISBN) {
		this.title = title;
		this.author = author;
        this.ISBN = ISBN;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

    public Integer getISBN() {
        return ISBN;
    } 

}