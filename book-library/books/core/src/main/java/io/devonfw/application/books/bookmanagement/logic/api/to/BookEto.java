package io.devonfw.application.books.bookmanagement.logic.api.to;

import io.devonfw.application.books.bookmanagement.common.api.Book;
import io.devonfw.application.books.general.common.api.to.AbstractEto;

/**
 * Entity transport object of Book
 */
public class BookEto extends AbstractEto implements Book {

  private static final long serialVersionUID = 1L;

  private String title;

  private String authorCode;

  @Override
  public String getTitle() {

    return title;
  }

  @Override
  public void setTitle(String title) {

    this.title = title;
  }

  @Override
  public String getAuthorCode() {

    return authorCode;
  }

  @Override
  public void setAuthorCode(String authorCode) {

    this.authorCode = authorCode;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
    result = prime * result + ((this.authorCode == null) ? 0 : this.authorCode.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    BookEto other = (BookEto) obj;
    if (this.title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!this.title.equals(other.title)) {
      return false;
    }
    if (this.authorCode == null) {
      if (other.authorCode != null) {
        return false;
      }
    } else if (!this.authorCode.equals(other.authorCode)) {
      return false;
    }
    return true;
  }
}
