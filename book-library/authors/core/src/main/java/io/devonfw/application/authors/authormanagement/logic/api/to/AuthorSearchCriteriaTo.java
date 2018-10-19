package io.devonfw.application.authors.authormanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.devonfw.application.authors.authormanagement.common.api.Author}s.
 *
 */
public class AuthorSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String code;

  private String country;

  /**
   * The constructor.
   */
  public AuthorSearchCriteriaTo() {

    super();
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getCode() {

    return code;
  }

  public void setCode(String code) {

    this.code = code;
  }

  public String getCountry() {

    return country;
  }

  public void setCountry(String country) {

    this.country = country;
  }

}
