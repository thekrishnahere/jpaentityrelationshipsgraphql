package com.entityrelations.example.jpaentityrelationshipsgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.entityrelations.example.jpaentityrelationshipsgraphql.dataservice.AuthorDataService;
import com.entityrelations.example.jpaentityrelationshipsgraphql.dataservice.BookDataService;
import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.AuthorDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Author;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.AuthorInput;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.Book;
import com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel.BookInput;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.AuthorDtoGqlMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.AuthorInputDtoMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.BookDtoGqlMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.BookInputDtoMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.service.IAuthorService;
import com.entityrelations.example.jpaentityrelationshipsgraphql.service.IBookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * mutation resolver.
 *
 * @author saikrishna
 */
@Component
public class MutationResolver implements GraphQLMutationResolver {

  /**
   * logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(MutationResolver.class);

  /**
   * book service.
   */
  @Autowired
  private IBookService bookService;

  /**
   * author service.
   */
  @Autowired
  private IAuthorService authorService;

  /**
   * author data service.
   */
  @Autowired
  private AuthorDataService authorDataService;

  /**
   * book data service.
   */
  @Autowired
  private BookDataService bookDataService;

  /**
   * create book.
   *
   * @param bookInput book input
   * @return book
   */
  public Book createBook(final BookInput bookInput) {

    Book resultBook =
        new BookDtoGqlMapper().apply(bookService.createOrUpdateBook(new BookInputDtoMapper().apply(bookInput)));
    LOGGER.debug("result book: {}", resultBook);
    return resultBook;
  }

  /**
   * create author.
   *
   * @param authorInput author input
   * @return author
   */
  public Author createAuthor(final AuthorInput authorInput) {
    Author resultAuthor =
        new AuthorDtoGqlMapper().apply(authorService.createOrUpdateAuthor(new AuthorInputDtoMapper().apply(authorInput)));
    LOGGER.debug("result author: {}", resultAuthor);
    return resultAuthor;
  }

  /**
   * add author to book.
   *
   * @param bookId      book id
   * @param authorInput author input
   * @return book
   */
  public Book addAuthor(final String bookId, final AuthorInput authorInput) {
    final AuthorDto authorDto = new AuthorInputDtoMapper().apply(authorInput);
    final AuthorDto resultAuthorDto = authorService.createOrUpdateAuthor(authorDto);
    LOGGER.debug("Fetched Author Dto: {}", resultAuthorDto);
    final BookDto resultBookDto = bookService.getBook(bookId);
    LOGGER.debug("Result Book Dto by Id: {}", resultBookDto);
    resultBookDto.getAuthorDtoSet().add(resultAuthorDto);
    LOGGER.debug("Updated Book Dto : {}", resultBookDto);
    final BookDto updatedResultBookDto = bookService.createOrUpdateBook(resultBookDto);
    LOGGER.debug("Updated Result Book Dto : {}", updatedResultBookDto);
    resultAuthorDto.getBookDtoSet().add(updatedResultBookDto);
    final AuthorDto resultUpdatedAuthorDto = authorService.createOrUpdateAuthor(resultAuthorDto);
    LOGGER.debug("Updated Result Book Dto : {}", resultUpdatedAuthorDto);
    return new BookDtoGqlMapper().apply(updatedResultBookDto);
  }

  /**
   * add book.
   *
   * @param authorId  author id
   * @param bookInput book input
   * @return author
   */
  public Author addBook(final String authorId, final BookInput bookInput) {
    final AuthorDto resultAuthorDto = authorService.getAuthor(authorId);
    LOGGER.debug("Result Author Dto By Id: {}", resultAuthorDto);
    resultAuthorDto.getBookDtoSet().add(new BookInputDtoMapper().apply(bookInput));
    LOGGER.debug("Updated Author Dto: {}", resultAuthorDto);
    final AuthorDto updatedAuthorDto = authorService.createOrUpdateAuthor(resultAuthorDto);
    LOGGER.debug("Result Updated Author Dto: {}", resultAuthorDto);
    return new AuthorDtoGqlMapper().apply(updatedAuthorDto);
  }
}
