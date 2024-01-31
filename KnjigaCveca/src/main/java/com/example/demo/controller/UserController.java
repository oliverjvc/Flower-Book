package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.repository.UserRepository;

import model.User;

@Controller
public class UserController {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration"; // Name of your registration JSP file
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Name of your login JSP file
    }
    
    
    //DOPUNITI 
    
    @GetMapping ("/users/getAll")
	public String getAll(Model m){
		m.addAttribute("users", ur.findAll());
		return "registerUser";
	}
	
	@PostMapping ("/admin/add")
	public String addUser(User u) {
     	u.setPassword(passwordEncoder.encode(u.getPassword()));
		ur.save(u);
		return "redirect:/users/getAll";
	}
	
    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable("id") int id) {
    	ur.deleteById(id);
    	return "redirect:/users/getAll";
    	
    }
}
