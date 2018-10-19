package io.devonfw.application.books.bookmanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.devonfw.application.books.bookmanagement.common.api.Book}s.
 *
 */
public class BookSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String title;

  private String authorCode;

  /**
   * The constructor.
   */
  public BookSearchCriteriaTo() {

    super();
  }

  public String getTitle() {

    return title;
  }

  public void setTitle(String title) {

    this.title = title;
  }

  public String getAuthorCode() {

    return authorCode;
  }

  public void setAuthorCode(String authorCode) {

    this.authorCode = authorCode;
  }

}
