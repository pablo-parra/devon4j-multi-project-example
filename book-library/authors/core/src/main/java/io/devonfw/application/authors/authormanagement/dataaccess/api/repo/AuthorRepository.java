package io.devonfw.application.authors.authormanagement.dataaccess.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.devonfw.application.authors.authormanagement.dataaccess.api.AuthorEntity;

/**
 * Repository for {@link AuthorEntity}
 *
 */
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

  @Query("SELECT a FROM AuthorEntity a WHERE a.code = :code")
  AuthorEntity findByCode(@Param("code") String code);
}
