package com.portfolio.easyjob.controller;

import com.portfolio.easyjob.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String loadPage(Model model){
        model.addAttribute("userForm", new User());
        return "/authentication/registration/form";
    }

}
