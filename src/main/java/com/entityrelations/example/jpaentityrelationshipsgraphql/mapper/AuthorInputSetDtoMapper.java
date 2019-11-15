package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.AuthorInput;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * author input set to author dto set mapper.
 *
 * @author saikrishna
 */
public class AuthorInputSetDtoMapper implements Function<Set<AuthorInput>, Set<AuthorDto>> {
  @Override
  public Set<AuthorDto> apply(final Set<AuthorInput> authorInputs) {
    return authorInputs.stream().map(authorInput -> new AuthorInputDtoMapper().apply(authorInput)).collect(Collectors.toSet());
  }
}
