package org.ukdaga.urlshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ukdaga.urlshortener.domain.Person;
import org.ukdaga.urlshortener.service.PersonService;

import java.util.List;

/**
 * Created by mbart on 28.02.2016.
 */
@Controller
public class IndexController {

  @Autowired
  private PersonService personService;

  @RequestMapping("/")
  public String showIndex(Model model) {
    List<Person> personList = personService.loadAll();

    model.addAttribute("personList", personList);

    return "index"; // return index.html Template
  }
}
