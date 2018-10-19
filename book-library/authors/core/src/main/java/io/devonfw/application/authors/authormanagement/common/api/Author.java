package io.devonfw.application.authors.authormanagement.common.api;

import io.devonfw.application.authors.general.common.api.ApplicationEntity;

public interface Author extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getCode();

  public void setCode(String code);

  public String getCountry();

  public void setCountry(String country);

}
