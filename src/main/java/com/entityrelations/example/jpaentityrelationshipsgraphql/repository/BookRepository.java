package com.entityrelations.example.jpaentityrelationshipsgraphql.repository;

import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * book repository.
 *
 * @author saikrishna
 */
public interface BookRepository extends JpaRepository<Book, String> {
}
