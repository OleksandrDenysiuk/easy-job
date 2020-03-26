package com.portfolio.easyjob.controller;

import com.portfolio.easyjob.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VerificationController {

    @GetMapping("/{userId}/verifying/details")
    public String loadPageDocVerifyDetails(@PathVariable User userId,
                                           Model model) {
        model.addAttribute("user", userId);
        return "/documents/details/index";
    }

    @PostMapping("/{userId}/verifying/result")
    public String verifyResult(@PathVariable User userId,
                               @RequestParam String userPhoto,
                               @RequestParam String passportPhoto,
                               @RequestParam(required = false) String legitimationPhoto) {


        return "redirect:/messages";
    }
}
