package com.entityrelations.example.jpaentityrelationshipsgraphql.graphqlmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * author input gql.
 *
 * @author saikrishna
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorInput {

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
  private Set<BookInput> books;

  /**
   * ring old id.
   */
  private Integer ringOldId;
}
