package com.example.authors.management.logic.api.dto;

/**
 * Data transfer object for Author entity
 *
 */
public class AuthorDTO {

  private int id;

  private String name;

  private String code;

  private String country;

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
