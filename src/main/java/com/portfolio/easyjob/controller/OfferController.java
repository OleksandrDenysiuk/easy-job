package com.portfolio.easyjob.controller;


import com.portfolio.easyjob.domain.Offer;
import com.portfolio.easyjob.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offer")
public class OfferController {

    @GetMapping("/form")
    public String loadForm(@AuthenticationPrincipal User user,
                           Model model){
        model.addAttribute("user", user);
        model.addAttribute("offer", new Offer());
        return "offer/form";
    }

    @PostMapping("/create")
    public String createOffer(@AuthenticationPrincipal User user,
                              @ModelAttribute Offer offer){

        System.out.println(offer.toString());

        return "redirect:/";
    }
}
