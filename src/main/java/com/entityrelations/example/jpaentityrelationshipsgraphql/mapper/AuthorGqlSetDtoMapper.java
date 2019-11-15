package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Author;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * author gql set to author dto set mapper.
 *
 * @author saikrishna
 */
public class AuthorGqlSetDtoMapper implements Function<Set<Author>, Set<AuthorDto>> {
  @Override
  public Set<AuthorDto> apply(final Set<Author> authors) {
    return authors.stream().map(author -> new AuthorGqlDtoMapper().apply(author)).collect(Collectors.toSet());
  }
}
