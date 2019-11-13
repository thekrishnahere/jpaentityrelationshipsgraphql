package com.entityrelations.example.jpaentityrelationshipsgraphql.service;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;

import java.util.Set;

/**
 * author service interface.
 *
 * @author saikrishna
 */
public interface IAuthorService {

  /**
   * create or update author.
   *
   * @param authorDto author dto
   * @return author dto
   */
  AuthorDto createOrUpdateAuthor(final AuthorDto authorDto);

  /**
   * get author by id.
   *
   * @param authorId author id
   * @return author dto
   */
  AuthorDto getAuthor(final String authorId);

  /**
   * get authors.
   *
   * @return set of author dto
   */
  Set<AuthorDto> getAuthors();
}
