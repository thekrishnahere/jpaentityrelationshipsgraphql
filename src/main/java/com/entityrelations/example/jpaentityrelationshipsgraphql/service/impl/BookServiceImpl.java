package com.entityrelations.example.jpaentityrelationshipsgraphql.service.impl;

import com.entityrelations.example.jpaentityrelationshipsgraphql.dataservice.BookDataService;
import com.entityrelations.example.jpaentityrelationshipsgraphql.dto.BookDto;
import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Book;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.BookDtoEntityMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.BookEntityDtoMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.mapper.BookEntitySetDtoMapper;
import com.entityrelations.example.jpaentityrelationshipsgraphql.service.IBookService;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * book service.
 *
 * @author saikrishna
 */
@Service
public class BookServiceImpl implements IBookService {

  /**
   * logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

  /**
   * book data service.
   */
  @Autowired
  private BookDataService bookDataService;

  @Override
  public BookDto createOrUpdateBook(BookDto bookDto) {

    final Book book = new BookDtoEntityMapper().apply(bookDto);
    final Book resultBook = bookDataService.createBook(book);
    return new BookEntityDtoMapper().apply(resultBook);
  }

  @Override
  public BookDto getBook(String bookId) {
    return new BookEntityDtoMapper().apply(bookDataService.getBook(bookId));
  }

  @Override
  public Set<BookDto> getBooks() {
    return new BookEntitySetDtoMapper().apply(bookDataService.getBooks());
  }
}
