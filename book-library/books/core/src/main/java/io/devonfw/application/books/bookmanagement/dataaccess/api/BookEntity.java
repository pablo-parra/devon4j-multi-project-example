package io.devonfw.application.books.bookmanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.devonfw.application.books.bookmanagement.common.api.Book;
import io.devonfw.application.books.general.dataaccess.api.ApplicationPersistenceEntity;

@Entity
@Table(name = "book")
public class BookEntity extends ApplicationPersistenceEntity implements Book {

  private String title;

  private String authorCode;

  private static final long serialVersionUID = 1L;

  /**
   * @return title
   */
  public String getTitle() {

    return this.title;
  }

  /**
   * @param title new value of {@link #getTitle}.
   */
  public void setTitle(String title) {

    this.title = title;
  }

  /**
   * @return authorCode
   */
  public String getAuthorCode() {

    return this.authorCode;
  }

  /**
   * @param authorCode new value of {@link #getAuthorCode}.
   */
  public void setAuthorCode(String authorCode) {

    this.authorCode = authorCode;
  }

}
