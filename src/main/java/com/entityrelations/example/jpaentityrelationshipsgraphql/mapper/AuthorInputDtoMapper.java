package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.AuthorInput;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

public class AuthorInputDtoMapper implements Function<AuthorInput, AuthorDto> {

  @Override
  public AuthorDto apply(AuthorInput authorInput) {
    return AuthorDto.builder().id(authorInput.getId()).name(authorInput.getName()).bookDtoSet(Optional.ofNullable(authorInput.getBooks()).isPresent() ? new BookInputSetDtoMapper().apply(authorInput.getBooks()) : new HashSet<>()).ringOldId(authorInput.getRingOldId()).build();
  }
}
