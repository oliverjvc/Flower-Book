package com.example.demo.service;

import org.springframework.stereotype.Service;

import model.User;

@Service
public interface UserService {
    boolean registerUser(User user);
    boolean userLogin(String username, String password);
	User register(User user);
	
	public boolean authenticateUser(String username, String password);
	boolean registerUser(User user, boolean isAdmin);
}
