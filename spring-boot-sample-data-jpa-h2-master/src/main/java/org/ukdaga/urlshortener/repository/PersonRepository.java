package org.ukdaga.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukdaga.urlshortener.domain.Person;

/**
 * Created by mbart on 28.02.2016.
 */
public interface PersonRepository extends JpaRepository<Person, Long>{
}
