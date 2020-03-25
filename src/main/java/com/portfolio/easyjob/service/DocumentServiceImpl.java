package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.Document;
import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.repository.DocumentRepository;
import com.portfolio.easyjob.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;
    public DocumentServiceImpl(DocumentRepository documentRepository, UserRepository userRepository) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void save(MultipartFile file, User user) {
        Document document = new Document();
        document.setUser(user);
        document.setLink(file.getName());
        document.setStatus("IN_PROGRESS");
        user.getDocuments().add(document);
        userRepository.save(user);
    }
}
