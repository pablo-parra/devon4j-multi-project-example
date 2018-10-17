package com.example.books.management.logic.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.authors.management.logic.api.Authormanagement;
import com.example.books.management.dataaccess.repository.BookRepository;
import com.example.books.management.logic.api.Bookmanagement;
import com.example.books.management.logic.api.dto.BookAndAuthorCTO;
import com.example.books.management.logic.api.dto.BookDTO;

/**
 * Implementation for Bookmanagement interface
 *
 */
@Service
@Transactional
public class BookmanagementImpl implements Bookmanagement {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private Authormanagement authormanagement;

  @Override
  public List<BookDTO> getAllBooks() {

    Type listType = new TypeToken<List<BookDTO>>() {
    }.getType();

    return mapper().map(this.bookRepository.findAll(), listType);
  }

  @Override
  public List<BookAndAuthorCTO> getAllBooksWithAuthorInfo() {

    Type listType = new TypeToken<List<BookDTO>>() {
    }.getType();

    List<BookAndAuthorCTO> booksAndAuthorsList = new ArrayList<>();
    List<BookDTO> booksDTO = mapper().map(this.bookRepository.findAll(), listType);

    for (BookDTO bookDTO : booksDTO) {
      BookAndAuthorCTO bookAndAuthor = new BookAndAuthorCTO();
      bookAndAuthor.setBook(bookDTO);
      bookAndAuthor.setAuthor(this.authormanagement.getAuthorByCode(bookDTO.getAuthorCode()));
      booksAndAuthorsList.add(bookAndAuthor);
    }

    return booksAndAuthorsList;
  }

  private ModelMapper mapper() {

    return new ModelMapper();
  }

}
