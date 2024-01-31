package com.example.demo.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Principal principal) {
        // Access the username
//        String username = principal.getName();

        // Access the roles
//        Collection<? extends GrantedAuthority> authorities = ((Authentication) principal).getAuthorities();
//        boolean isAdmin = authorities.stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

        // Your logic based on user roles
        // ...

        return "admin_dashboard";
    }
}

