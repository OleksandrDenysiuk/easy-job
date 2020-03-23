package com.portfolio.easyjob.controller;

import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String loadPage(Model model){
        model.addAttribute("userForm", new User());
        return "/authentication/registration/form";
    }


    @PostMapping("/registration")
    public String registerUser(@ModelAttribute User user){
        userService.create(user);
        return "redirect:/";
    }
}
