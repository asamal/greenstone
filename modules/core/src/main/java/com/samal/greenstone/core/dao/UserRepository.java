package com.samal.greenstone.core.dao;

import com.samal.greenstone.core.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "customers")
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);

    List<User> findByName(String name);
}
