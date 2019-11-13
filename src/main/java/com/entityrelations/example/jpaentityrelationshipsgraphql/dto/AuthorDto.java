package com.entityrelations.example.jpaentityrelationshipsgraphql.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * author dto.
 *
 * @author saikrishna
 */
@Data
@Builder
public class AuthorDto {

  /**
   * id.
   */
  private String id;

  /**
   * author name.
   */
  private String name;

  /**
   * ring old id.
   */
  private Integer ringOldId;

  /**
   * books.
   */
  private Set<BookDto> bookDtoSet;
}
