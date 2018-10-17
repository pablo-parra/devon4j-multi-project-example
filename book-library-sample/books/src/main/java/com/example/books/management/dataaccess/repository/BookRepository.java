package com.example.books.management.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.books.management.dataaccess.entity.Book;

/**
 * Repository for Book entity
 *
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

}
