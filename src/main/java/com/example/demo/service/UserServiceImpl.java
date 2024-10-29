package com.example.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    
    public String getRole(String username) {
        if ("anonymousUser".equals(username)) {
            // Return a default role or handle anonymous users
            return "ROLE_ANONYMOUS";
        }

        User u = userRepository.getByName(username);
        if (u == null) {
            throw new IllegalArgumentException("User not found for username: " + username);
        }

        return u.getRole();
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

	// Implement the method to save a user
    @Override
    public void save(User user) {
        userRepository.save(user); // Use repository to save the user
    }
	// Implement the method to find a user by username
    @Override
    public User findByUsername(String username) {
        Optional<User> userOptional = Optional.of(userRepository.findByUsername(username));
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
