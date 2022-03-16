package com.lejap59.booklibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		System.out.println("BOOKAPPLICATION");
		SpringApplication.run(BookApplication.class, args);
	}

}
