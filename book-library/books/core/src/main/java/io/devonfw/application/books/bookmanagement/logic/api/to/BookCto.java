package io.devonfw.application.books.bookmanagement.logic.api.to;

import io.devonfw.application.books.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Book
 */
public class BookCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private BookEto book;

  public BookEto getBook() {

    return book;
  }

  public void setBook(BookEto book) {

    this.book = book;
  }

}
