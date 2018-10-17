package com.example.authors.management.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity for author table
 *
 */
@Entity
@Table(name = "author")
public class Author {

  @Id
  private int id;

  @NotNull
  private String name;

  @NotNull
  private String code;

  private String country;

  /**
   * @return id
   */
  public int getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getId}.
   */
  public void setId(int id) {

    this.id = id;
  }

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getName}.
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
   * @param code new value of {@link #getCode}.
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
   * @param country new value of {@link #getCountry}.
   */
  public void setCountry(String country) {

    this.country = country;
  }

}
