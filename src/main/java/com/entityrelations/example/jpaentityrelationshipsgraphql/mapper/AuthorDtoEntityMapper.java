package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Author;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

/**
 * author dto to entity mapper.
 *
 * @author saikrishna
 */
public class AuthorDtoEntityMapper implements Function<AuthorDto, Author> {

  @Override
  public Author apply(AuthorDto authorDto) {
    Author author = new Author();
    author.setId(authorDto.getId());
    author.setName(authorDto.getName());
    author.setRingOldId(authorDto.getRingOldId());
    author.setBookSet(Optional.ofNullable(authorDto.getBookDtoSet()).isPresent() ?
        new BookDtoSetEntityMapper().apply(authorDto.getBookDtoSet()) : new HashSet<>());
    return author;
  }
}
