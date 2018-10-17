package com.example.books.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.books.management.logic.api.Bookmanagement;

/**
 * REST controller for Books service
 *
 */
@Controller
@RequestMapping("/api/v1")
public class BooksController {

  @Autowired
  private Bookmanagement bookmanagement;

  /**
   * @return the list of all books in the DB
   */
  @RequestMapping(value = "/getBooks", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<?> getBooks() {

    return new ResponseEntity<>(this.bookmanagement.getAllBooks(), HttpStatus.OK);
  }

  @RequestMapping(value = "/getBooksWithAuthorsInfo", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<?> getBooksWithAuthorsInfo() {

    return new ResponseEntity<>(this.bookmanagement.getAllBooksWithAuthorInfo(), HttpStatus.OK);
  }

}
