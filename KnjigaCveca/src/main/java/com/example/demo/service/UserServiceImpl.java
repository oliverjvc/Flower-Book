package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.UserRepository;

import model.User;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean registerUser(User user, boolean isAdmin){
   
        if (userRepository.existsByUsernameOrEmail(user.getUsername(), user.getEmail())) {
            return false; // User with the same username or email already exists
        }
        if (isAdmin) {
			user.setRole("ROLE_ADMIN");
		}
        user.setRole("ROLE_USER");
        // Encode the password before saving it to the database
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
     
       
        
        return true;
    }
       
	

	@Override
	public boolean userLogin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
