package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.UserService;

import model.User;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    
    
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("isAdmin", false); // Default is a regular user
        return "registration"; 
    }

    @PostMapping("/registration")
    public String processRegistration(@ModelAttribute("user") User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        
        if (userService.registerUser(user, isAdmin)) {
            // Registration success
            return "redirect:/registrationSuccess.jsp";
        } else {
            // Registration failed
            return "redirect:/registration?error";
        }
    }
}
