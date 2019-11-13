package com.entityrelations.example.jpaentityrelationshipsgraphql.mapper;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Author;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

/**
 * author dto to gql mapper.
 *
 * @author saikrishna
 */
public class AuthorDtoGqlMapper implements Function<AuthorDto, Author> {
  @Override
  public Author apply(AuthorDto authorDto) {
    return Author.builder().id(authorDto.getId()).ringOldId(authorDto.getRingOldId()).name(authorDto.getName()).books(Optional.ofNullable(authorDto.getBookDtoSet()).isPresent() ? new BookDtoSetGqlMapper().apply(authorDto.getBookDtoSet()) : new HashSet<>()).build();
  }
}
