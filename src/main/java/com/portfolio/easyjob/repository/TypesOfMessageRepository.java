package com.portfolio.easyjob.repository;

import com.portfolio.easyjob.domain.TypeOfMessage;
import org.springframework.data.repository.CrudRepository;

public interface TypesOfMessageRepository extends CrudRepository<TypeOfMessage,Long> {
    TypeOfMessage findByName(String name);
}
