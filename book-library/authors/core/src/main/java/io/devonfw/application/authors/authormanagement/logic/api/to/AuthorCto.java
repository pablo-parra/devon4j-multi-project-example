package io.devonfw.application.authors.authormanagement.logic.api.to;

import io.devonfw.application.authors.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Author
 */
public class AuthorCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private AuthorEto author;

  public AuthorEto getAuthor() {

    return author;
  }

  public void setAuthor(AuthorEto author) {

    this.author = author;
  }

}
