package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Book;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

public class BookDtoGqlMapper implements Function<BookDto, Book> {
  @Override
  public Book apply(BookDto bookDto) {
    return Book.builder().id(bookDto.getId()).category(bookDto.getCategory()).name(bookDto.getName()).authors(Optional.ofNullable(bookDto.getAuthorDtoSet()).isPresent() ? new AuthorDtoSetGqlMapper().apply(bookDto.getAuthorDtoSet()) : new HashSet<>()).isbn(bookDto.getIsbn()).build();
  }
}
