package com.entityrelations.example.jpaentityrelationshipsgraphql.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * book dto.
 *
 * @author saikrishna
 */
@Data
@Builder
public class BookDto {

  /**
   * id.
   */
  private String id;

  /**
   * book name.
   */
  private String name;

  /**
   * isbn.
   */
  private Integer isbn;

  /**
   * authors.
   */
  private Set<AuthorDto> authorDtoSet;

  /**
   * book category.
   */
  private String category;
}
