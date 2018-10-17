package com.example.authors.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.authors.management.logic.api.Authormanagement;
import com.example.authors.management.logic.api.dto.AuthorDTO;

/**
 * REST controller for Authors service
 *
 */
@Controller
@RequestMapping("/api/v1")
public class AuthorsController {

  @Autowired
  private Authormanagement authormanagement;

  /**
   * @return the list of all books in the DB
   */
  @RequestMapping(value = "/getAuthors", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<?> getAuthors() {

    return new ResponseEntity<>(this.authormanagement.getAuthors(), HttpStatus.OK);
  }

  @RequestMapping(value = "/getAuthorByCode/{code}", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<AuthorDTO> getAuthorByCode(@PathVariable("code") String code) {

    return new ResponseEntity<>(this.authormanagement.getAuthorByCode(code), HttpStatus.OK);
  }
}
