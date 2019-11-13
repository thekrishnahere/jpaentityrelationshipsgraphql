package com.entityrelations.example.jpaentityrelationshipsgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Author;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Book;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.AuthorDtoGqlMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.AuthorDtoSetGqlMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.BookDtoGqlMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.BookDtoSetGqlMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.service.IAuthorService;
import com.entityrelations.example.jpaentityrelationshipsgraphql.service.IBookService;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * query resolver.
 *
 * @author saikrishna
 */
@Component
public class QueryResolver implements GraphQLQueryResolver {

  /**
   * logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(QueryResolver.class);

  /**
   * author service.
   */
  @Autowired
  private IAuthorService authorService;

  /**
   * book service.
   */
  @Autowired
  private IBookService bookService;

  /**
   * get book by Id.
   *
   * @param bookId book Id
   * @return Book
   */
  public Book getBook(final String bookId) {
    return new BookDtoGqlMapper().apply(bookService.getBook(bookId));
  }

  /**
   * get all books.
   *
   * @param category book category
   * @return set of books
   */
  public Set<Book> getBooks(final String category) {
    return new BookDtoSetGqlMapper().apply(bookService.getBooks());
  }

  /**
   * get author by id.
   *
   * @param authorId author id
   * @return author
   */
  public Author getAuthor(final String authorId) {
    return new AuthorDtoGqlMapper().apply(authorService.getAuthor(authorId));
  }

  /**
   * get all authors.
   *
   * @return set of authors
   */
  public Set<Author> getAuthors() {
    return new AuthorDtoSetGqlMapper().apply(authorService.getAuthors());
  }
}
