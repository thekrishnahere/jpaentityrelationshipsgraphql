package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Author;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * author dto set to author graphql set mapper.
 *
 * @author saikrishna
 */
public class AuthorDtoSetGqlMapper implements Function<Set<AuthorDto>, Set<Author>> {
  @Override
  public Set<Author> apply(final Set<AuthorDto> authorDtoSet) {
    return authorDtoSet.stream().map(authorDto -> new AuthorDtoGqlMapper().apply(authorDto)).collect(Collectors.toSet());
  }
}
