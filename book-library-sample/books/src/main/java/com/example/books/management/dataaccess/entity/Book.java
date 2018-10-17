package com.example.books.management.dataaccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity for book table
 *
 */
@Entity
@Table(name = "book")
public class Book {

  @Id
  private int id;

  @NotNull
  private String title;

  @NotNull
  @Column(name = "author_code")
  private String authorCode;

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
