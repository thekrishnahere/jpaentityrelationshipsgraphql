package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Book;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

/**
 * book gql to book dto mapper.
 *
 * @author saikrishna
 */
public class BookGqlDtoMapper implements Function<Book, BookDto> {
  @Override
  public BookDto apply(final Book book) {
    return BookDto.builder().id(book.getId()).name(book.getName()).category(book.getCategory()).isbn(book.getIsbn()).authorDtoSet(Optional.ofNullable(book.getAuthors()).isPresent() ? new AuthorGqlSetDtoMapper().apply(book.getAuthors()) : new HashSet<>()).build();
  }
}
