package com.example.demo.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	
    @GetMapping("/dashboard")
    public String adminDashboard(Principal principal) {
        // Access the username
//        String username = principal.getName();

        // Access the roles
//        Collection<? extends GrantedAuthority> authorities = ((Authentication) principal);
//        boolean isAdmin = authorities.stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

        // Your logic based on user roles
        // ...

        return "admin/dashboard";
    }
}

