package com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {

  /**
   * ID.
   */
  private String id;

  /**
   * Book Name.
   */
  private String name;

  /**
   * Book Author.
   */
  private Set<AuthorInput> authors;

  /**
   * Book Category.
   */
  private String category;

  private Integer isbn;
}