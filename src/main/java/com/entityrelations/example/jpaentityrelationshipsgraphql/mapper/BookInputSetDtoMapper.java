package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.BookInput;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookInputSetDtoMapper implements Function<Set<BookInput>, Set<BookDto>> {
  @Override
  public Set<BookDto> apply(Set<BookInput> bookInputs) {
    return bookInputs.stream().map(bookInput -> new BookInputDtoMapper().apply(bookInput)).collect(Collectors.toSet());
  }
}
