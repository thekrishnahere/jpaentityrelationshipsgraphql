package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Author;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * author dto set to author entity set mapper.
 *
 * @author saikrishna
 */
public class AuthorDtoSetEntityMapper implements Function<Set<AuthorDto>, Set<Author>> {

  @Override
  public Set<Author> apply(final Set<AuthorDto> authorDtoSet) {
    return authorDtoSet.stream().map(authorDto -> new AuthorDtoEntityMapper().apply(authorDto)).collect(Collectors.toSet());
  }
}
