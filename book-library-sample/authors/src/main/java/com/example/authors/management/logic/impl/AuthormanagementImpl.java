package com.example.authors.management.logic.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.authors.management.dataaccess.repository.AuthorRepository;
import com.example.authors.management.logic.api.Authormanagement;
import com.example.authors.management.logic.api.dto.AuthorDTO;

/**
 * Implementation for the Authormanagement interface
 *
 */
@Service
@Transactional
public class AuthormanagementImpl implements Authormanagement {

  @Autowired
  private AuthorRepository authorRepository;

  @Override
  public List<AuthorDTO> getAuthors() {

    Type listType = new TypeToken<List<AuthorDTO>>() {
    }.getType();

    return mapper().map(this.authorRepository.findAll(), listType);
  }

  @Override
  public AuthorDTO getAuthorByCode(String code) {

    return mapper().map(this.authorRepository.findByCode(code), AuthorDTO.class);
  }

  private ModelMapper mapper() {

    return new ModelMapper();
  }

}
