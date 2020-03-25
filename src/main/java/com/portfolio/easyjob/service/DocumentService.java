package com.portfolio.easyjob.service;


import com.portfolio.easyjob.domain.User;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

    void save(MultipartFile document, User user);
}
