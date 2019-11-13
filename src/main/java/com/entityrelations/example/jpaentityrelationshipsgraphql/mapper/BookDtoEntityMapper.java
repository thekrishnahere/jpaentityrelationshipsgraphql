package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Book;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

public class BookDtoEntityMapper implements Function<BookDto, Book> {
  @Override
  public Book apply(BookDto bookDto) {
    Book book = new Book();
    book.setId(bookDto.getId());
    book.setName(bookDto.getName());
    book.setCategory(bookDto.getCategory());
    book.setIsbn(bookDto.getIsbn());
    book.setAuthorSet(Optional.ofNullable(bookDto.getAuthorDtoSet()).isPresent() ?
        new AuthorDtoSetEntityMapper().apply(bookDto.getAuthorDtoSet()) : new HashSet<>());
    return book;
  }
}
