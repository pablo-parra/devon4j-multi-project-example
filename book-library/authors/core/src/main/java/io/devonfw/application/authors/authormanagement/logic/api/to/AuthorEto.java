package io.devonfw.application.authors.authormanagement.logic.api.to;

import io.devonfw.application.authors.authormanagement.common.api.Author;
import io.devonfw.application.authors.general.common.api.to.AbstractEto;

/**
 * Entity transport object of Author
 */
public class AuthorEto extends AbstractEto implements Author {

  private static final long serialVersionUID = 1L;

  private String name;

  private String code;

  private String country;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getCode() {

    return code;
  }

  @Override
  public void setCode(String code) {

    this.code = code;
  }

  @Override
  public String getCountry() {

    return country;
  }

  @Override
  public void setCountry(String country) {

    this.country = country;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
    result = prime * result + ((this.country == null) ? 0 : this.country.hashCode());
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
    AuthorEto other = (AuthorEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.code == null) {
      if (other.code != null) {
        return false;
      }
    } else if (!this.code.equals(other.code)) {
      return false;
    }
    if (this.country == null) {
      if (other.country != null) {
        return false;
      }
    } else if (!this.country.equals(other.country)) {
      return false;
    }
    return true;
  }
}
