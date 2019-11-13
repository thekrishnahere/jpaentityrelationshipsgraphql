package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Author;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AuthorDtoSetEntityMapper implements Function<Set<AuthorDto>, Set<Author>> {

  @Override
  public Set<Author> apply(Set<AuthorDto> authorDtoSet) {
    return authorDtoSet.stream().map(authorDto -> new AuthorDtoEntityMapper().apply(authorDto)).collect(Collectors.toSet());
  }
}
