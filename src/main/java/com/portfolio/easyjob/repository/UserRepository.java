package com.portfolio.easyjob.repository;

import com.portfolio.easyjob.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String name);
}
