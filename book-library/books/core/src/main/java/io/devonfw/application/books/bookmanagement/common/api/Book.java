package io.devonfw.application.books.bookmanagement.common.api;

import io.devonfw.application.books.general.common.api.ApplicationEntity;

public interface Book extends ApplicationEntity {

  public String getTitle();

  public void setTitle(String title);

  public String getAuthorCode();

  public void setAuthorCode(String authorCode);

}
