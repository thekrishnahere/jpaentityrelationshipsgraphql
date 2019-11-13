package com.entityrelations.example.jpaentityrelationshipsgraphql.service.impl;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dataservice.AuthorDataService;
import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.AuthorDtoEntityMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.AuthorEntityDtoMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.AuthorEntitySetDtoMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.service.IAuthorService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author service.
 *
 * @author saikrishna
 */
@Service
public class AuthorServiceImpl implements IAuthorService {

  @Autowired
  private AuthorDataService authorDataService;

  @Override
  public AuthorDto createOrUpdateAuthor(AuthorDto authorDto) {
    return new AuthorEntityDtoMapper().apply(authorDataService.createOrUpdateAuthor(new AuthorDtoEntityMapper().apply(authorDto)));
  }

  @Override
  public Set<AuthorDto> getAuthors() {
    return new AuthorEntitySetDtoMapper().apply(authorDataService.getAuthors());
  }

  @Override
  public AuthorDto getAuthor(String authorId) {
    return new AuthorEntityDtoMapper().apply(authorDataService.getAuthor(authorId));
  }


}
