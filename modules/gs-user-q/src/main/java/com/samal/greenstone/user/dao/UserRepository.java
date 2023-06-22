package com.samal.greenstone.user.dao;

import com.samal.greenstone.user.domain.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "customers")
public interface UserRepository extends CrudRepository<User, Long> {
  User findById(long id);

  List<User> findByName(String name);
}
