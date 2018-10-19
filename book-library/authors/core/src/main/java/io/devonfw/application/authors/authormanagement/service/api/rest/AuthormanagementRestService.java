package io.devonfw.application.authors.authormanagement.service.api.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.devonfw.application.authors.authormanagement.logic.api.Authormanagement;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorCto;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorEto;
import io.devonfw.application.authors.authormanagement.logic.api.to.AuthorSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Authormanagement}.
 */
@Path("/authormanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AuthormanagementRestService {

  /**
   * Delegates to {@link Authormanagement#findAuthor}.
   *
   * @param id the ID of the {@link AuthorEto}
   * @return the {@link AuthorEto}
   */
  @GET
  @Path("/author/{id}/")
  public AuthorEto getAuthor(@PathParam("id") long id);

  /**
   * Delegates to {@link Authormanagement#saveAuthor}.
   *
   * @param author the {@link AuthorEto} to be saved
   * @return the recently created {@link AuthorEto}
   */
  @POST
  @Path("/author/")
  public AuthorEto saveAuthor(AuthorEto author);

  /**
   * Delegates to {@link Authormanagement#deleteAuthor}.
   *
   * @param id ID of the {@link AuthorEto} to be deleted
   */
  @DELETE
  @Path("/author/{id}/")
  public void deleteAuthor(@PathParam("id") long id);

  /**
   * Delegates to {@link Authormanagement#findAuthorEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding authors.
   * @return the {@link PaginatedListTo list} of matching {@link AuthorEto}s.
   */
  @Path("/author/search")
  @POST
  public List<AuthorEto> findAuthorsByPost(AuthorSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Authormanagement#findAuthorCto}.
   *
   * @param id the ID of the {@link AuthorCto}
   * @return the {@link AuthorCto}
   */
  @GET
  @Path("/author/cto/{id}/")
  public AuthorCto getAuthorCto(@PathParam("id") long id);

  /**
   * Delegates to {@link Authormanagement#findAuthorCtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding authors.
   * @return the {@link PaginatedListTo list} of matching {@link AuthorCto}s.
   */
  @Path("/author/cto/search")
  @POST
  public PaginatedListTo<AuthorCto> findAuthorCtosByPost(AuthorSearchCriteriaTo searchCriteriaTo);

}