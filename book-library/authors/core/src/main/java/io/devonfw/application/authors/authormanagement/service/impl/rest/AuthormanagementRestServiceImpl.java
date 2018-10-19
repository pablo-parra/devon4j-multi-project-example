package io.devonfw.application.authors.authormanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.devonfw.application.authors.authormanagement.logic.api.Authormanagement;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorCto;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorEto;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorSearchCriteriaTo;
import io.devonfw.application.authors.authormanagement.service.api.rest.AuthormanagementRestService;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Authormanagement}.
 */
@Named("AuthormanagementRestService")
public class AuthormanagementRestServiceImpl implements AuthormanagementRestService {

  @Inject
  private Authormanagement authormanagement;

  @Override
  public AuthorEto getAuthor(long id) {

    return this.authormanagement.findAuthor(id);
  }

  @Override
  public AuthorEto saveAuthor(AuthorEto author) {

    return this.authormanagement.saveAuthor(author);
  }

  @Override
  public void deleteAuthor(long id) {

    this.authormanagement.deleteAuthor(id);
  }

  @Override
  public List<AuthorEto> findAuthorsByPost(AuthorSearchCriteriaTo searchCriteriaTo) {

    return this.authormanagement.findAuthorEtos(searchCriteriaTo);
  }

  @Override
  public AuthorCto getAuthorCto(long id) {

    return this.authormanagement.findAuthorCto(id);
  }

  @Override
  public PaginatedListTo<AuthorCto> findAuthorCtosByPost(AuthorSearchCriteriaTo searchCriteriaTo) {

    return this.authormanagement.findAuthorCtos(searchCriteriaTo);
  }
}