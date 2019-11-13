package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Author;

import java.util.function.Function;
import java.util.stream.Collectors;

public class AuthorEntityDtoMapper implements Function<Author, AuthorDto> {

  @Override
  public AuthorDto apply(Author author) {
    return AuthorDto.builder().id(author.getId()).name(author.getName())
        .ringOldId(author.getRingOldId())
        .bookDtoSet(author.getBookSet().stream().map(book -> BookDto.builder().isbn(book.getIsbn()).id(book.getId()).name(book.getName()).category(book.getCategory()).build()).collect(Collectors.toSet())
//            Optional.ofNullable(author.getBookSet()).isPresent() ?
//            new BookEntitySetDtoMapper().apply(author.getBookSet()) : new HashSet<>()
        )
        .build();
  }
}
