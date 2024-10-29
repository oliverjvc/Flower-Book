package com.example.demo.dto;

import java.util.List;

public class LoginResponseDTO {
    private String token;
    private Object user;
    
    public LoginResponseDTO(String token, Object user) {
		super();
		this.token = token;
		this.user = user;
	}
    // Constructor, Getters and Setters
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Object getUser() {
		return user;
	}
	public void setUser(Object user) {
		this.user = user;
	}
	
    
	
    
}
