package com.example.authors.management.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.authors.management.dataaccess.entity.Author;

/**
 * Repository for Author entity
 *
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {

  @Query("SELECT a FROM Author a WHERE a.code = :code")
  Author findByCode(@Param("code") String code);
}
