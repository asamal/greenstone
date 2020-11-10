package com.samal.greenstone;

import com.samal.greenstone.dao.UserRepository;
import com.samal.greenstone.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class GreenstoneApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreenstoneApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new User("Jack", "Bauer"));
            repository.save(new User("Chloe", "O'Brian"));
            repository.save(new User("Kim", "Bauer"));
            repository.save(new User("David", "Palmer"));
            repository.save(new User("Michelle", "Dessler"));

            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            User customer = repository.findById(1L);
            log.info("User found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("User found with findByLastName('Jack Bauer'):");
            log.info("--------------------------------------------");
            repository.findByName("Jack Bauer").forEach(bauer -> log.info(bauer.toString()));
            for (User bauer : repository.findByName("Jack Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }
}
