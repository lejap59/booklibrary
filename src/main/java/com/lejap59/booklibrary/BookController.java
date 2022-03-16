package com.lejap59.booklibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BookController {
     @Autowired
     private BookService bookService;

     @RequestMapping("/findBook")
     String findBook(@RequestParam("ISBN") Integer ISBN) {
          System.out.println("METHODE FINDBOOK");
          Book book =  bookService.findBook(ISBN);
          if (book != null) {
               return book.getISBN().toString();
          } else {
               return null;
          }
     }

@RequestMapping("/addBook")
     String addBook(@RequestParam("title") String title, @RequestParam("author") String author, @RequestParam("ISBN") Integer ISBN) {
          System.out.println("METHODE ADDBOOK");
          return bookService.addBook(title, author, ISBN);
      }
     
}
