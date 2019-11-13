package com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * book input gql.
 *
 * @author saikrishna
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {

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
  private Set<AuthorInput> authors;

  /**
   * book category.
   */
  private String category;

  /**
   * isbn.
   */
  private Integer isbn;
}
