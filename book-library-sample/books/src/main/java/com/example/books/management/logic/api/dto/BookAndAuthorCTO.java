package com.example.books.management.logic.api.dto;

import com.example.authors.management.logic.api.dto.AuthorDTO;

/**
 * Transfer Object for the author data
 *
 */
public class BookAndAuthorCTO {

  BookDTO book;

  AuthorDTO author;

  /**
   * @return book
   */
  public BookDTO getBook() {

    return this.book;
  }

  /**
   * @param book new value of {@link #getbook}.
   */
  public void setBook(BookDTO book) {

    this.book = book;
  }

  /**
   * @return author
   */
  public AuthorDTO getAuthor() {

    return this.author;
  }

  /**
   * @param author new value of {@link #getauthor}.
   */
  public void setAuthor(AuthorDTO author) {

    this.author = author;
  }

}
