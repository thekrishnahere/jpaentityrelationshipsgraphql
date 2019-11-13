package com.entityrelations.example.jpaentityrelationshipsgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Author;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Book;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.AuthorDtoGqlMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.service.IAuthorService;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * book resolver.
 *
 * @author saikrishna
 */
@Service
public class BookResolver implements GraphQLResolver<Book> {

  /**
   * author service.
   */
  @Autowired
  private IAuthorService authorService;

  /**
   * get authors.
   *
   * @param book book
   * @return set of authors
   */
  public Set<Author> getAuthors(final Book book) {
    return book.getAuthors().stream().map(author -> new AuthorDtoGqlMapper().apply(authorService.getAuthor(author.getId()))).collect(Collectors.toSet());
  }
}
