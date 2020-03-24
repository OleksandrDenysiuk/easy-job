package com.portfolio.easyjob.controller;

import com.portfolio.easyjob.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String loadPage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user",user);
        return "index";
    }
}
