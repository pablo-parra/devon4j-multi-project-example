package com.example.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.books", "com.example.authors" })
public class BooksApplication {

  public static void main(String[] args) {

    SpringApplication.run(BooksApplication.class, args);
  }
}
