package io.devonfw.application.authors.authormanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.devonfw.application.authors.authormanagement.common.api.Author;
import io.devonfw.application.authors.general.dataaccess.api.ApplicationPersistenceEntity;

@Entity
@Table(name = "author")
public class AuthorEntity extends ApplicationPersistenceEntity implements Author {

  private String name;

  private String code;

  private String country;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return code
   */
  public String getCode() {

    return this.code;
  }

  /**
   * @param code new value of {@link #getcode}.
   */
  public void setCode(String code) {

    this.code = code;
  }

  /**
   * @return country
   */
  public String getCountry() {

    return this.country;
  }

  /**
   * @param country new value of {@link #getcountry}.
   */
  public void setCountry(String country) {

    this.country = country;
  }

}
