package com.entityrelations.example.jpaentityrelationshipsgraphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

/**
 * author.
 *
 * @author saikrishna
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
public class Author {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "author_id")
  private String id;

  @NaturalId
  @Column(name = "ring_old_id")
  private Integer ringOldId;

  @Column(name = "name")
  private String name;

  @ManyToMany(cascade =
      {
          CascadeType.MERGE,
          CascadeType.PERSIST
      }
      , fetch = FetchType.EAGER
      , mappedBy = "authorSet"
  )
  private Set<Book> bookSet = new HashSet<>(0);

  public void addBook(final Book book) {
    this.bookSet.add(book);
    book.getAuthorSet().add(this);
  }

  public void removeBook(final Book book) {
    this.bookSet.remove(book);
    book.getAuthorSet().remove(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (!(o instanceof Author))
      return false;

    Author author = (Author) o;
    return Objects.equals(ringOldId, author.ringOldId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ringOldId);
  }
}
