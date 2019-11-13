package com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * book.
 *
 * @author saikrishna
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  /**
   * id.
   */
  private String id;

  /**
   * book name.
   */
  private String name;

  /**
   * book author.
   */
  private Set<Author> authors;

  /**
   * book category.
   */
  private String category;

  /**
   * isbn.
   */
  private Integer isbn;
}
