package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Book;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * book dto set to book gql set mapper.
 *
 * @author saikrishna
 */
public class BookDtoSetGqlMapper implements Function<Set<BookDto>, Set<Book>> {
  @Override
  public Set<Book> apply(final Set<BookDto> bookDtoSet) {
    return bookDtoSet.isEmpty() ? new HashSet<>() :
        bookDtoSet.stream().map(bookDto -> new BookDtoGqlMapper().apply(bookDto)).collect(Collectors.toSet());
  }
}
