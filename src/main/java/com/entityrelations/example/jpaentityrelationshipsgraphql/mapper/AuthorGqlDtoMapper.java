package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Author;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

public class AuthorGqlDtoMapper implements Function<Author, AuthorDto> {
  @Override
  public AuthorDto apply(Author author) {
    return AuthorDto.builder().id(author.getId()).ringOldId(author.getRingOldId()).name(author.getName()).bookDtoSet(Optional.ofNullable(author.getBooks()).isPresent() ? new BookGqlSetDtoMapper().apply(author.getBooks()) : new HashSet<>()).build();
  }
}
