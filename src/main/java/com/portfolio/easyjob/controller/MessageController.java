package com.portfolio.easyjob.controller;

import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.service.MessageService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping
    public String loadPage(@AuthenticationPrincipal User user,
                           Model model) {

        if (user.isAdmin()) {
            model.addAttribute("messages", messageService.getAllByUser(user));
            return "/messages/admin/index";
        }

        return "index";
    }
}
