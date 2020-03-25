package com.portfolio.easyjob.controller;

import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.service.DocumentService;
import com.portfolio.easyjob.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
@RequestMapping("/documents")
public class DocumentsController {

    private final MessageService messageService;
    private final DocumentService documentService;

    public DocumentsController(MessageService messageService, DocumentService documentService) {
        this.messageService = messageService;
        this.documentService = documentService;
    }

    @GetMapping
    public String loadPage(@AuthenticationPrincipal User user,
                           Model model) {

        String statusOfDocuments = user.documentsStatus();

        model.addAttribute("statusOfDocuments", statusOfDocuments);


        model.addAttribute("user", user);
        if (user.isEmployee()) {
            return "/documents/employee/index";
        } else if (user.isEmployer()) {
            return "/documents/employee/index";
        } else {
            return "index";
        }
    }

    @PostMapping("/employee/send")
    public String sendEmployeeDocToVerification(@AuthenticationPrincipal User user,
                                                @RequestParam MultipartFile userPhoto,
                                                @RequestParam MultipartFile passportPhoto,
                                                @RequestParam(required = false) MultipartFile legitimationPhoto) {

        documentService.save(userPhoto, user);
        documentService.save(passportPhoto, user);

        if (legitimationPhoto != null) {
            documentService.save(userPhoto, user);
        }

        messageService.create(user, "VERIFY_DOC");

        return "redirect:/documents";
    }
}
