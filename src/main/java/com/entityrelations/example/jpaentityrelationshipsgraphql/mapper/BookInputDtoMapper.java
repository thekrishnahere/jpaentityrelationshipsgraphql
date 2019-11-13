package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.BookInput;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

public class BookInputDtoMapper implements Function<BookInput, BookDto> {

  @Override
  public BookDto apply(BookInput bookInput) {
    return BookDto.builder().id(bookInput.getId()).name(bookInput.getName()).isbn(bookInput.getIsbn()).category(bookInput.getCategory()).authorDtoSet(Optional.ofNullable(bookInput.getAuthors()).isPresent() ? new AuthorInputSetDtoMapper().apply(bookInput.getAuthors()) : new HashSet<>()).build();
  }
}
