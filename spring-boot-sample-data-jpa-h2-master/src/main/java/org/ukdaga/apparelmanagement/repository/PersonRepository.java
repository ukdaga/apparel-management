package org.ukdaga.apparelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukdaga.apparelmanagement.domain.Person;

/**
 * Created by mbart on 28.02.2016.
 */
public interface PersonRepository extends JpaRepository<Person, Long>{
}
