package com.portfolio.easyjob.repository;

import com.portfolio.easyjob.domain.TypeOfDocument;
import org.springframework.data.repository.CrudRepository;

public interface TypeOfDocumentRepository extends CrudRepository<TypeOfDocument, Long> {
    TypeOfDocument findByName(String name);
}
