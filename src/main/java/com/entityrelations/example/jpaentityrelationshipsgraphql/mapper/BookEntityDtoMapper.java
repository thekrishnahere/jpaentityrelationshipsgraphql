package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Book;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * book entity to book dto mapper.
 *
 * @author saikrishna
 */
public class BookEntityDtoMapper implements Function<Book, BookDto> {

  @Override
  public BookDto apply(final Book book) {
    return BookDto.builder().id(book.getId()).category(book.getCategory()).name(book.getName()).isbn(book.getIsbn())
        .authorDtoSet(book.getAuthorSet().stream().map(author -> AuthorDto.builder().id(author.getId()).ringOldId(author.getRingOldId()).name(author.getName()).build()).collect(Collectors.toSet()))
        .build();
  }
}
