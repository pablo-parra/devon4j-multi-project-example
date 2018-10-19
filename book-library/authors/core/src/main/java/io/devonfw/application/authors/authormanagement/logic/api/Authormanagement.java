package io.devonfw.application.authors.authormanagement.logic.api;

import java.util.List;

import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorCto;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorEto;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Authormanagement component.
 */
public interface Authormanagement {

  /**
   * Returns a Author by its id 'id'.
   *
   * @param id The id 'id' of the Author.
   * @return The {@link AuthorEto} with id 'id'
   */
  AuthorEto findAuthor(Long id);

  /**
   * Returns a paginated list of Authors matching the search criteria.
   *
   * @param criteria the {@link AuthorSearchCriteriaTo}.
   * @return the {@link List} of matching {@link AuthorEto}s.
   */
  List<AuthorEto> findAuthorEtos(AuthorSearchCriteriaTo criteria);

  /**
   * Deletes a author from the database by its id 'authorId'.
   *
   * @param authorId Id of the author to delete
   * @return boolean <code>true</code> if the author can be deleted, <code>false</code> otherwise
   */
  boolean deleteAuthor(Long authorId);

  /**
   * Saves a author and store it in the database.
   *
   * @param author the {@link AuthorEto} to create.
   * @return the new {@link AuthorEto} that has been saved with ID and version.
   */
  AuthorEto saveAuthor(AuthorEto author);

  /**
   * Returns a composite Author by its id 'id'.
   *
   * @param id The id 'id' of the Author.
   * @return The {@link AuthorCto} with id 'id'
   */
  AuthorCto findAuthorCto(Long id);

  /**
   * Returns a paginated list of composite Authors matching the search criteria.
   *
   * @param criteria the {@link AuthorSearchCriteriaTo}.
   * @return the {@link List} of matching {@link AuthorCto}s.
   */
  PaginatedListTo<AuthorCto> findAuthorCtos(AuthorSearchCriteriaTo criteria);

}