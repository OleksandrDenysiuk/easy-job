package com.portfolio.easyjob.controller;

import com.portfolio.easyjob.domain.Employee;
import com.portfolio.easyjob.domain.Employer;
import com.portfolio.easyjob.domain.User;
import com.portfolio.easyjob.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public String loadPage(@AuthenticationPrincipal User user, Model model) {

        model.addAttribute("user", user);

        if (user.isEmployee()) {
            model.addAttribute("employeeForm", user.getEmployee());
            return "/profile/employee/index";
        } else if (user.isEmployer()) {
            model.addAttribute("employerForm", user.getEmployer());
            return "/profile/employer/index";
        } else {
            log.debug("Error with user role");
            return "index";
        }
    }

    @PostMapping("/update/employee")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @ModelAttribute Employee employeeForm,
                                @RequestParam(defaultValue = "false") boolean studentStatus,
                                @RequestParam String username,
                                @RequestParam String newpassword){
        employeeForm.setStudent(studentStatus);
        profileService.update(user.getEmployee(), employeeForm,user, username,newpassword);
        return "redirect:/profile";
    }

    @PostMapping("/update/employer")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @ModelAttribute Employer employerForm,
                                @RequestParam String username,
                                @RequestParam String newpassword) {

        profileService.update(user.getEmployer(), employerForm, user, username,newpassword);
        return "redirect:/profile";
    }

}
