package com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * author gql.
 *
 * @author saikrishna
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

  /**
   * id.
   */
  private String id;

  /**
   * author name.
   */
  private String name;

  /**
   * books.
   */
  private Set<Book> books;

  /**
   * ring old id.
   */
  private Integer ringOldId;
}
