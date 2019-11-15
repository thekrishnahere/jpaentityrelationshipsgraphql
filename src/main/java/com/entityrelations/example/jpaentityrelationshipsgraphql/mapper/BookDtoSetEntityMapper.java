package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Book;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * book dto set to boot entity set mapper.
 *
 * @author saikrishna
 */
public class BookDtoSetEntityMapper implements Function<Set<BookDto>, Set<Book>> {

  @Override
  public Set<Book> apply(final Set<BookDto> bookDtoSet) {
    return bookDtoSet.stream().map(bookDto -> new BookDtoEntityMapper().apply(bookDto)).collect(Collectors.toSet());
  }
}
