package com.entityrelations.example.jpaentityrelationshipsgraphql.dataservice;

import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Book;
import com.entityrelations.example.jpaentityrelationshipsgraphql.repository.AuthorRepository;
import com.entityrelations.example.jpaentityrelationshipsgraphql.repository.BookRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * book data service.
 *
 * @author saikrishna
 */
@Service
public class BookDataService {

  /**
   * logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(BookDataService.class);

  /**
   * book repository.
   */
  @Autowired
  private BookRepository bookRepository;

  /**
   * author repository.
   */
  @Autowired
  private AuthorRepository authorRepository;

  /**
   * create book.
   *
   * @param book book
   * @return book
   */
  public Book createBook(final Book book) {
    LOGGER.debug("Book Entity input: {}", book);
    final Book resultBook = bookRepository.save(book);
    LOGGER.debug("result book: {}", resultBook);
    final Optional<Book> updatedResultBook = bookRepository.findById(resultBook.getId());
    return updatedResultBook.orElse(new Book());
  }

  /**
   * get book by id.
   *
   * @param bookId book id
   * @return book
   */
  public Book getBook(final String bookId) {
    final Optional<Book> resultBook = bookRepository.findById(bookId);
    LOGGER.debug("result book by id: {}", resultBook.get());
    return resultBook.orElse(new Book());
  }

  /**
   * get all books.
   *
   * @return set of books
   */
  public Set<Book> getBooks() {
    return new HashSet<>(bookRepository.findAll());
  }
}
