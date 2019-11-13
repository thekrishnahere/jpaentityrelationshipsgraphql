package com.entityrelations.example.jpaentityrelationshipsgraphql.dataservice;

import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Author;
import com.entityrelations.example.jpaentityrelationshipsgraphql.repository.AuthorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author data service.
 *
 * @author saikrishna
 */
@Service
public class AuthorDataService {

  /**
   * logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(AuthorDataService.class);

  /**
   * author repository.
   */
  @Autowired
  private AuthorRepository authorRepository;

  /**
   * get all authors.
   *
   * @return set of authors.
   */
  public Set<Author> getAuthors() {
    final List<Author> authorList = authorRepository.findAll();
    LOGGER.debug("authors list: {}", authorList);
    return new HashSet<>(authorList);
  }

  /**
   * get author by id.
   *
   * @param authorId author id
   * @return author
   */
  public Author getAuthor(final String authorId) {
    final Optional<Author> authorOpt = authorRepository.findById(authorId);
    LOGGER.debug("author : {}", authorOpt);
    return authorOpt.orElse(new Author());
  }

  /**
   * create or update author.
   *
   * @param author author
   * @return author
   */
  public Author createOrUpdateAuthor(Author author) {
    final Author resultAuthor = authorRepository.save(author);
    LOGGER.debug("result author: {}", resultAuthor);
    return resultAuthor;
  }
}