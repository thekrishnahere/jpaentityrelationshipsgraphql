package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Author;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AuthorEntitySetDtoMapper implements Function<Set<Author>, Set<AuthorDto>> {

  @Override
  public Set<AuthorDto> apply(Set<Author> authorSet) {
    return authorSet.isEmpty() ? new HashSet<>() :
        authorSet.stream().map(author -> new AuthorEntityDtoMapper().apply(author)).collect(Collectors.toSet());
  }
}
