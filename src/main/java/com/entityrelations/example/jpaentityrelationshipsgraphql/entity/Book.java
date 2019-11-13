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

/**
 * book.
 *
 * @author saikrishna
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "book_id")
  private String id;

  /**
   * ISBN.
   * Unique Identifier for Book. (a part from id).
   */
  @Column(name = "isbn")
  private Integer isbn;

  @Column(name = "category")
  private String category;

  @Column(name = "name")
  private String name;

  @ManyToMany(cascade =
      {
          CascadeType.MERGE,
          CascadeType.PERSIST
      }
      , fetch = FetchType.EAGER
  )
//  @JoinTable(name = "authorbooks", joinColumns = {@JoinColumn(name = "book", referencedColumnName = "book_id")},
//      inverseJoinColumns = {@JoinColumn(name = "author", referencedColumnName = "author_id")})
  private Set<Author> authorSet = new HashSet<>(0);

  public void addAuthor(final Author author) {
    //avoid circular calls : assumes equals and hashcode implemented
    if (!authorSet.contains(author)) {
      this.authorSet.add(author);
      author.getBookSet().add(this);
    }
  }

  public void removeAuthor(final Author author) {
    //avoid circular calls: assumes equals and hashcode implemented:
    if (authorSet.contains(author)) {
      this.authorSet.remove(author);
      author.getBookSet().remove(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (!(o instanceof Book)) return false;

    Book thatBook = (Book) o;
    return Objects.equals(isbn, thatBook.isbn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn);
  }
}
