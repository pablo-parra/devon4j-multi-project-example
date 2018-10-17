package com.example.authors.management.logic.api;

import java.util.List;

import com.example.authors.management.logic.api.dto.AuthorDTO;

/**
 * Interface for Author management logic
 *
 */
public interface Authormanagement {

  List<AuthorDTO> getAuthors();

  AuthorDTO getAuthorByCode(String code);
}
