package com.entityrelations.example.jpaentityrelationshipsgraphql.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AuthorDto {

  /**
   * ID.
   */
  private String id;

  /**
   * Author Name.
   */
  private String name;

  private Integer ringOldId;

  /**
   * Books.
   */
  private Set<BookDto> bookDtoSet;
}
