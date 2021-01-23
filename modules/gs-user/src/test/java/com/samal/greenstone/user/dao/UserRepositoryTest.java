package com.samal.greenstone.user.dao;

import com.samal.greenstone.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void demo() {
        // save a few customers
        User user = new User("Jack", "Bauer");
        user.setUuid(UUID.randomUUID());
        user.setEmail("jack@bauer.com");
        repository.save(user);
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
            assertEquals("jack@bauer.com", user.getEmail());
        }
        log.info("");
    }
}