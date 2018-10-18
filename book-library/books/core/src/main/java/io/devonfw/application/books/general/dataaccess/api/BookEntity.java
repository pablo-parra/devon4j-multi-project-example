package io.devonfw.application.books.general.dataaccess.api;

import java.awt.print.Book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@link ApplicationPersistenceEntity Entity} for {@link Book}
 *
 */
@Entity
@Table(name = "book")
public class BookEntity {

  private String title;

  @Column(name = "author_code")
  private String authorCode;

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
