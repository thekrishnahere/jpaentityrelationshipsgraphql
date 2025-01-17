package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Book;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * book gql set to book dto set mapper.
 *
 * @author saikrishna
 */
public class BookGqlSetDtoMapper implements Function<Set<Book>, Set<BookDto>> {
  @Override
  public Set<BookDto> apply(final Set<Book> books) {
    return books.stream().map(book -> new BookGqlDtoMapper().apply(book)).collect(Collectors.toSet());
  }
}
