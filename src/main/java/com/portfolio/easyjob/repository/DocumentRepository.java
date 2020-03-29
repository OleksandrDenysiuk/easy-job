package com.portfolio.easyjob.repository;

import com.portfolio.easyjob.domain.Document;
import com.portfolio.easyjob.domain.TypeOfDocument;
import com.portfolio.easyjob.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
    Document findByUserAndType(User user, TypeOfDocument typeOfDocument);
}
