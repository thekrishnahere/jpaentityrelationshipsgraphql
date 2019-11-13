package com.entityrelations.example.jpaentityrelationshipsgraphql.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BookDto {
  /**
   * ID.
   */
  private String id;

  /**
   * Book Name.
   */
  private String name;

  private Integer isbn;

  /**
   * Book Author.
   */
  private Set<AuthorDto> authorDtoSet;

  /**
   * Book Category.
   */
  private String category;
}
