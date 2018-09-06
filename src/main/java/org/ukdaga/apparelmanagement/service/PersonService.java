package org.ukdaga.apparelmanagement.service;

import java.util.List;

import org.ukdaga.apparelmanagement.domain.Person;

/**
 * Created by mbart on 28.02.2016.
 */
public interface PersonService {
  List<Person> loadAll();
}
