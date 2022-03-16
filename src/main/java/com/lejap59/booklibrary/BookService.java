package com.lejap59.booklibrary;
import org.springframework.stereotype.Service;
 @Service
public class BookService {

    private Book book;

    public Book findBook(Integer ISBN) {
          if (book != null && book.getISBN() == ISBN) {
                return book;       
          } else {
              return null;
          }
    }

    public String addBook(String title, String author, Integer ISBN) {
		book = new Book(title, author,ISBN);
        return "ADD BOOK OK";
    }
}