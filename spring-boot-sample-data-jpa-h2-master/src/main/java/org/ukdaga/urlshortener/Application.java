package org.ukdaga.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.ukdaga.urlshortener.domain.Apparel;
import org.ukdaga.urlshortener.domain.Person;
import org.ukdaga.urlshortener.repository.ApparelRepository;
import org.ukdaga.urlshortener.repository.PersonRepository;

@SpringBootApplication
@EnableJpaRepositories
public class Application {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

    PersonRepository personRepository = context.getBean(PersonRepository.class);
    personRepository.save(new Person("Hans", "Meiser"));
    personRepository.save(new Person("Peter", "Lustig"));
    personRepository.save(new Person("Peter", "Parker"));
    
    ApparelRepository apparelRepository = context.getBean(ApparelRepository.class);
    apparelRepository.save(new Apparel("name" , "type" ,0, "apparelType"));
  }
  
  @Bean
  public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {

      System.out.println(new ShallowEtagHeaderFilter());
      return new ShallowEtagHeaderFilter();
  }

}
