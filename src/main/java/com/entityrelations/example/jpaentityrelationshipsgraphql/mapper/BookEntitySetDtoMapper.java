package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Book;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookEntitySetDtoMapper implements Function<Set<Book>, Set<BookDto>> {

  @Override
  public Set<BookDto> apply(Set<Book> bookSet) {
    return bookSet.isEmpty() ? new HashSet<>() :
        bookSet.stream().map(book -> new BookEntityDtoMapper().apply(book)).collect(Collectors.toSet());
  }
}
