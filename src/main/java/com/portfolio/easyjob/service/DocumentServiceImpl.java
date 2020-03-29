package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Document;
import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.repository.DocumentRepository;
import com.portfolio.easyjob.repository.StatusOfDocumentRepository;
import com.portfolio.easyjob.repository.TypeOfDocumentRepository;
import com.portfolio.easyjob.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;
    private final StatusOfDocumentRepository statusOfDocumentRepository;
    private final TypeOfDocumentRepository typeOfDocumentRepository;
    public DocumentServiceImpl(DocumentRepository documentRepository, UserRepository userRepository, StatusOfDocumentRepository statusOfDocumentRepository, TypeOfDocumentRepository typeOfDocumentRepository) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
        this.statusOfDocumentRepository = statusOfDocumentRepository;
        this.typeOfDocumentRepository = typeOfDocumentRepository;
    }


    @Override
    public void save(MultipartFile file, User user, String type) {
        Document document = new Document();
        document.setUser(user);
        document.setLink(file.getName());
        document.setStatus(statusOfDocumentRepository.findByName("IN_PROGRESS"));
        document.setType(typeOfDocumentRepository.findByName(type));
        user.getDocuments().add(document);
        userRepository.save(user);
        documentRepository.save(document);
    }

    @Override
    public Document changeStatus(User user, String typeOfDocument, String statusOfDocument) {
        Document document = documentRepository.findByUserAndType(user, typeOfDocumentRepository.findByName(typeOfDocument));

        System.out.println(document);
        document.setStatus(statusOfDocumentRepository.findByName(statusOfDocument));
        documentRepository.save(document);
        userRepository.save(user);
        return document;
    }
}
