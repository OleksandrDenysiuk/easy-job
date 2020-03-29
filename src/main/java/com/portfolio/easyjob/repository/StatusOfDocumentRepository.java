package com.portfolio.easyjob.repository;

import com.portfolio.easyjob.domain.StatusOfDocument;
import org.springframework.data.repository.CrudRepository;

public interface StatusOfDocumentRepository extends CrudRepository<StatusOfDocument, Long> {
    StatusOfDocument findByName(String name);
}
