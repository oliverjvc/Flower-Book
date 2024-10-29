package com.example.demo.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.UserRepository;

import model.User;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }

	public User findById(Integer userId) {
		return userRepository.findUserById(userId);
	}
}
