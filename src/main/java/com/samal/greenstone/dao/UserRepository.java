package com.samal.greenstone.dao;

import com.samal.greenstone.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);

    List<User> findByName(String name);
}
