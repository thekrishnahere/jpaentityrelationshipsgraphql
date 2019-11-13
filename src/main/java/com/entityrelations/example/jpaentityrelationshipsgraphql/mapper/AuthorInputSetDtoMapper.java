package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.AuthorInput;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AuthorInputSetDtoMapper implements Function<Set<AuthorInput>, Set<AuthorDto>> {
  @Override
  public Set<AuthorDto> apply(Set<AuthorInput> authorInputs) {
    return authorInputs.stream().map(authorInput -> new AuthorInputDtoMapper().apply(authorInput)).collect(Collectors.toSet());
  }
}
