package org.ukdaga.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ukdaga.urlshortener.domain.Person;
import org.ukdaga.urlshortener.repository.PersonRepository;

import java.util.List;

/**
 * Created by mbart on 28.02.2016.
 */
@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public List<Person> loadAll() {
    return personRepository.findAll();
  }
}
