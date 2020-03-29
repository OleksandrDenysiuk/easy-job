package com.portfolio.easyjob.controller;

import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.service.VerificationService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/documents")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @GetMapping("/{userId}/verifying/details")
    public String loadPageDocVerifyDetails(@PathVariable User userId,
                                           Model model) {
        model.addAttribute("user", userId);
        return "/documents/details/index";
    }

    @PostMapping("/{userId}/verifying/result")
    public String verifyResult(
            @AuthenticationPrincipal User admin,
            @PathVariable User userId,
            @RequestParam String userPhoto,
            @RequestParam String passportPhoto,
            @RequestParam(required = false) String legitimationPhoto) {


        if (legitimationPhoto != null) {
            verificationService.verify(admin,userId, userPhoto, passportPhoto, legitimationPhoto);
        } else {
            verificationService.verify(admin,userId, userPhoto, passportPhoto);
        }


        return "redirect:/messages";
    }
}
