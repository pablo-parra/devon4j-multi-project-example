package io.devonfw.application.books.bookmanagement.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import io.devonfw.application.books.bookmanagement.dataaccess.api.BookEntity;
import io.devonfw.application.books.bookmanagement.dataaccess.api.repo.BookRepository;
import io.devonfw.application.books.bookmanagement.logic.api.Bookmanagement;
import io.devonfw.application.books.bookmanagement.logic.api.to.BookCto;
import io.devonfw.application.books.bookmanagement.logic.api.to.BookEto;
import io.devonfw.application.books.bookmanagement.logic.api.to.BookSearchCriteriaTo;
import io.devonfw.application.books.general.logic.base.AbstractComponentFacade;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.common.api.to.PaginationResultTo;

/**
 * Implementation of component interface of {@link Bookmanagement}
 */
@Named
@Transactional
public class BookmanagementImpl extends AbstractComponentFacade implements Bookmanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(BookmanagementImpl.class);

  /** @see #getBookDao() */
  @Inject
  private BookRepository bookRepository;

  /**
   * The constructor.
   */
  public BookmanagementImpl() {

    super();
  }

  @Override
  public BookEto findBook(Long id) {

    LOG.debug("Get Book with id {} from database.", id);
    BookEntity b = this.bookRepository.findOne(id);
    return getBeanMapper().map(b, BookEto.class);
  }

  @Override
  public List<BookEto> findBookEtos(BookSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);

    Example<BookEntity> filters = Example.of(toBookEntity(criteria));
    List<BookEntity> books = this.bookRepository.findAll(filters);
    return getBeanMapper().mapList(books, BookEto.class);
  }

  @Override
  public boolean deleteBook(Long bookId) {

    BookEntity book = this.bookRepository.findOne(bookId);
    this.bookRepository.delete(book);
    LOG.debug("The book with id '{}' has been deleted.", bookId);
    return true;
  }

  @Override
  public BookEto saveBook(BookEto book) {

    Objects.requireNonNull(book, "book");
    BookEntity bookEntity = getBeanMapper().map(book, BookEntity.class);

    // initialize, validate bookEntity here if necessary
    BookEntity resultEntity = this.bookRepository.save(bookEntity);
    LOG.debug("Book with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, BookEto.class);
  }

  @Override
  public BookCto findBookCto(Long id) {

    LOG.debug("Get BookCto with id {} from database.", id);
    BookEntity entity = this.bookRepository.findOne(id);
    BookCto cto = new BookCto();
    cto.setBook(getBeanMapper().map(entity, BookEto.class));

    return cto;
  }

  @Override
  public PaginatedListTo<BookCto> findBookCtos(BookSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    Example<BookEntity> filters = Example.of(toBookEntity(criteria));
    List<BookEntity> books = this.bookRepository.findAll(filters);
    List<BookCto> ctos = new ArrayList<>();
    for (BookEntity entity : books) {
      BookCto cto = new BookCto();
      cto.setBook(getBeanMapper().map(entity, BookEto.class));
      ctos.add(cto);

    }
    PaginationResultTo pagResultTo = new PaginationResultTo(criteria.getPagination(), (long) ctos.size());
    PaginatedListTo<BookCto> pagListTo = new PaginatedListTo(ctos, pagResultTo);
    return pagListTo;
  }

  private BookEntity toBookEntity(BookSearchCriteriaTo criteria) {

    BookEntity book = new BookEntity();
    book.setAuthorCode(criteria.getAuthorCode());
    book.setTitle(criteria.getTitle());
    return book;
  }

}