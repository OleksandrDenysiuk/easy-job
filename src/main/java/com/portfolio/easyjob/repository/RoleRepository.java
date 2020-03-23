package com.portfolio.easyjob.repository;

import com.portfolio.easyjob.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
