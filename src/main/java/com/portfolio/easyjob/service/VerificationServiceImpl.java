package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.User;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final DocumentService documentService;
    private final MessageService messageService;

    public VerificationServiceImpl(DocumentService documentService, MessageService messageService) {

        this.documentService = documentService;
        this.messageService = messageService;
    }

    @Override
    public void verify(User admin, User userId, String statusUserPhoto, String statusPassport, String statusLegitimation) {

        documentService.changeStatus(userId, "USER_PHOTO", statusUserPhoto);
        documentService.changeStatus(userId, "PASSPORT", statusPassport);
        documentService.changeStatus(userId, "LEGITIMATION", statusLegitimation);

        if (userId.documentsStatus().equals("NOT_VERIFIED")) {
            messageService.create(admin, userId, "VERIFY_RESULT", "Something is wrong. Please try again!");
        } else if (userId.documentsStatus().equals("VERIFIED")) {
            messageService.create(admin, userId, "VERIFY_RESULT", "Everything okay. Your documents are verified!");
        }

        messageService.deleteByUserAndType(admin,"VERIFY_DOC");
    }

    @Override
    public void verify(User admin, User userId, String statusUserPhoto, String statusPassport) {

        documentService.changeStatus(userId, "PHOTO_USER", statusUserPhoto);
        documentService.changeStatus(userId, "PASSPORT", statusPassport);

        if (userId.documentsStatus().equals("NOT_VERIFIED")) {
            messageService.create(admin, userId, "VERIFY_RESULT", "Something is wrong. Please try again!");
        } else if (userId.documentsStatus().equals("VERIFIED")) {
            messageService.create(admin, userId, "VERIFY_RESULT", "Everything okay. Your documents are verified!");
        }

        messageService.deleteByUserAndType(admin,"VERIFY_DOC");

    }
}
