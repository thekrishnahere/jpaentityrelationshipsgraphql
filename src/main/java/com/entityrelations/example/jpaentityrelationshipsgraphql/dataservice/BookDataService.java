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

  @Autowired
  private AuthorRepository authorRepository;

  public Book createBook(final Book book) {
//    book.getAuthorSet().stream().forEach(author -> {
//      author.addBook(book);
//    });
//    bookRepository.save(book);
    LOGGER.debug("Book Entity input: {}", book);
//    Set<Author> authors =
//        book.getAuthorSet().stream().map(author -> {
//          if (Optional.ofNullable(author.getId()).isPresent()) {
//            Author resultAuthor = authorRepository.getOne(author.getId());
//            LOGGER.debug("Author by id : {}", resultAuthor.getId());
//            return resultAuthor;
//          }
//          return author;
//        }).collect(Collectors.toSet());
//    book.setAuthorSet(authors);
    final Book resultBook = bookRepository.save(book);
    LOGGER.debug("result book: {}", resultBook);
    final Optional<Book> updatedResultBook = bookRepository.findById(resultBook.getId());
//    LOGGER.debug("Updated Result Book: {}", updatedResultBook);
    return updatedResultBook.get();
  }

  public Book getBook(final String bookId) {
    final Optional<Book> resultBook = bookRepository.findById(bookId);
    LOGGER.debug("result book by id: {}", resultBook.get());
    return resultBook.orElse(new Book());
  }

  public Set<Book> getBooks() {
    return new HashSet<>(bookRepository.findAll());
  }
}
