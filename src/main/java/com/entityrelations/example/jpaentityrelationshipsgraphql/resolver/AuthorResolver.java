package com.entityrelations.example.jpaentityrelationshipsgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Author;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Book;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.BookDtoGqlMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.service.IBookService;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author resolver.
 *
 * @author saikrishna
 */
@Service
public class AuthorResolver implements GraphQLResolver<Author> {

  /**
   * book service.
   */
  @Autowired
  private IBookService bookService;

  /**
   * get books.
   *
   * @param author author
   * @return set of books
   */
  public Set<Book> getBooks(final Author author) {
    return author.getBooks().stream().map(book -> new BookDtoGqlMapper().apply(bookService.getBook(book.getId()))).collect(Collectors.toSet());
  }
}
