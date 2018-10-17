package com.example.books.management.logic.api.dto;

/**
 * Data Transfer Object for Book Entity
 *
 */
public class BookDTO {

  private int id;

  private String title;

  private String authorCode;

  /**
   * @return id
   */
  public int getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getid}.
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
   * @param title new value of {@link #gettitle}.
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
   * @param authorCode new value of {@link #getauthorCode}.
   */
  public void setAuthorCode(String authorCode) {

    this.authorCode = authorCode;
  }

}
