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
public class AuthorInput {

  /**
   * ID.
   */
  private String id;

  /**
   * Author Name.
   */
  private String name;

  /**
   * Books.
   */
  private Set<BookInput> books;

  private Integer ringOldId;
}
