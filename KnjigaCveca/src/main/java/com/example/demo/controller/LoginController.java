package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.UserServiceImpl;

import model.User;


@Controller
public class LoginController {
	
	@Autowired
	UserServiceImpl userService;
    
	@GetMapping("/")
    public String getHomePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // This assumes the userId is stored as the username
		String role = userService.getRole(name);
        
        if (role.equals("ROLE_ADMIN")) {
            return "redirect:/admin/dashboard.jsp";
        } 
            return "redirect:/home.jsp";
        }
}
