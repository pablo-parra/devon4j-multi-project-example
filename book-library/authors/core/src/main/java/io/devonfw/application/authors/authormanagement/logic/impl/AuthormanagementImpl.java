package io.devonfw.application.authors.authormanagement.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import io.devonfw.application.authors.authormanagement.dataaccess.api.AuthorEntity;
import io.devonfw.application.authors.authormanagement.dataaccess.api.repo.AuthorRepository;
import io.devonfw.application.authors.authormanagement.logic.api.Authormanagement;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorCto;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorEto;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorSearchCriteriaTo;
import io.devonfw.application.authors.general.logic.base.AbstractComponentFacade;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.common.api.to.PaginationResultTo;

/**
 * Implementation of component interface of authormanagement
 */
@Named
@Transactional
public class AuthormanagementImpl extends AbstractComponentFacade implements Authormanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(AuthormanagementImpl.class);

  /** @see #getAuthorDao() */
  @Inject
  private AuthorRepository authorRepository;

  /**
   * The constructor.
   */
  public AuthormanagementImpl() {

    super();
  }

  @Override
  public AuthorEto findAuthor(Long id) {

    LOG.debug("Get Author with id {} from database.", id);
    return getBeanMapper().map(this.authorRepository.findOne(id), AuthorEto.class);
  }

  @Override
  public List<AuthorEto> findAuthorEtos(AuthorSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);

    Example<AuthorEntity> filters = Example.of(toAuthorEntity(criteria));
    List<AuthorEntity> authors = this.authorRepository.findAll(filters);

    return getBeanMapper().mapList(authors, AuthorEto.class);
  }

  @Override
  public boolean deleteAuthor(Long authorId) {

    AuthorEntity author = this.authorRepository.findOne(authorId);
    this.authorRepository.delete(author);
    LOG.debug("The author with id '{}' has been deleted.", authorId);
    return true;
  }

  @Override
  public AuthorEto saveAuthor(AuthorEto author) {

    Objects.requireNonNull(author, "author");
    AuthorEntity authorEntity = getBeanMapper().map(author, AuthorEntity.class);

    // initialize, validate authorEntity here if necessary
    AuthorEntity resultEntity = this.authorRepository.save(authorEntity);
    LOG.debug("Author with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, AuthorEto.class);
  }

  @Override
  public AuthorCto findAuthorCto(Long id) {

    LOG.debug("Get AuthorCto with id {} from database.", id);
    AuthorEntity entity = this.authorRepository.findOne(id);
    AuthorCto cto = new AuthorCto();
    cto.setAuthor(getBeanMapper().map(entity, AuthorEto.class));

    return cto;
  }

  @Override
  public PaginatedListTo<AuthorCto> findAuthorCtos(AuthorSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    Example<AuthorEntity> filters = Example.of(toAuthorEntity(criteria));
    List<AuthorEntity> authors = this.authorRepository.findAll(filters);
    List<AuthorCto> ctos = new ArrayList<>();
    for (AuthorEntity entity : authors) {
      AuthorCto cto = new AuthorCto();
      cto.setAuthor(getBeanMapper().map(entity, AuthorEto.class));
      ctos.add(cto);

    }
    PaginationResultTo pagResultTo = new PaginationResultTo(criteria.getPagination(), (long) ctos.size());
    PaginatedListTo<AuthorCto> pagListTo = new PaginatedListTo(ctos, pagResultTo);
    return pagListTo;
  }

  private AuthorEntity toAuthorEntity(AuthorSearchCriteriaTo criteria) {

    AuthorEntity author = new AuthorEntity();
    author.setCode(criteria.getCode());
    author.setCountry(criteria.getCountry());
    author.setName(criteria.getName());
    return author;
  }

}