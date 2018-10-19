package io.devonfw.application.books.bookmanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.devonfw.application.books.bookmanagement.logic.api.Bookmanagement;
import io.devonfw.application.books.bookmanagement.logic.api.to.BookCto;
import io.devonfw.application.books.bookmanagement.logic.api.to.BookEto;
import io.devonfw.application.books.bookmanagement.logic.api.to.BookSearchCriteriaTo;
import io.devonfw.application.books.bookmanagement.service.api.rest.BookmanagementRestService;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Bookmanagement}.
 */
@Named("BookmanagementRestService")
public class BookmanagementRestServiceImpl implements BookmanagementRestService {

  @Inject
  private Bookmanagement bookmanagement;

  @Override
  public BookEto getBook(long id) {

    return this.bookmanagement.findBook(id);
  }

  @Override
  public BookEto saveBook(BookEto book) {

    return this.bookmanagement.saveBook(book);
  }

  @Override
  public void deleteBook(long id) {

    this.bookmanagement.deleteBook(id);
  }

  @Override
  public List<BookEto> findBooksByPost(BookSearchCriteriaTo searchCriteriaTo) {

    return this.bookmanagement.findBookEtos(searchCriteriaTo);
  }

  @Override
  public BookCto getBookCto(long id) {

    return this.bookmanagement.findBookCto(id);
  }

  @Override
  public PaginatedListTo<BookCto> findBookCtosByPost(BookSearchCriteriaTo searchCriteriaTo) {

    return this.bookmanagement.findBookCtos(searchCriteriaTo);
  }
}