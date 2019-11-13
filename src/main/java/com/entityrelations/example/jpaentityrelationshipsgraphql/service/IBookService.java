package com.entityrelations.example.jpaentityrelationshipsgraphql.service;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;

import java.util.Set;

/**
 * book service interface.
 *
 * @author saikrishna
 */
public interface IBookService {

  /**
   * create or update book.
   *
   * @param bookDto book dto
   * @return book dto
   */
  BookDto createOrUpdateBook(final BookDto bookDto);

  /**
   * get books.
   *
   * @param bookId book id
   * @return book dto
   */
  BookDto getBook(final String bookId);

  /**
   * get books.
   *
   * @return set of book dto
   */
  Set<BookDto> getBooks();
}
