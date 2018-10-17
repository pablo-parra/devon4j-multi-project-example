package com.example.books.management.logic.api;

import java.util.List;

import com.example.books.management.logic.api.dto.BookAndAuthorCTO;
import com.example.books.management.logic.api.dto.BookDTO;

/**
 * Interface for the logic layer of the book management
 *
 */
public interface Bookmanagement {

  List<BookDTO> getAllBooks();

  List<BookAndAuthorCTO> getAllBooksWithAuthorInfo();
}
