package io.devonfw.application.books.bookmanagement.dataaccess.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.devonfw.application.books.bookmanagement.dataaccess.api.BookEntity;

/**
 * Repository for Book entity
 *
 */
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
