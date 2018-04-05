package de.michlb.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import de.michlb.sample.domain.Apparel;
import de.michlb.sample.domain.Person;
import de.michlb.sample.repositories.ApparelRepository;
import de.michlb.sample.repositories.PersonRepository;

@SpringBootApplication
@EnableJpaRepositories
public class SampleApplication {


  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(SampleApplication.class, args);

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
