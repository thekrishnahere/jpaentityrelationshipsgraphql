package com.entityrelations.example.jpaentityrelationshipsgraphql.repository;

import com.entityrelations.example.jpaentityrelationshipsgraphql.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author repository.
 *
 * @author saikrishna
 */
public interface AuthorRepository extends JpaRepository<Author, String> {

}
