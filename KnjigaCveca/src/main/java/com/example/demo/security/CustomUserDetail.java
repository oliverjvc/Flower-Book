package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import model.User;

public class CustomUserDetail implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User u;
	private String email;  // Add the 'email' property
	private String role;
	
    // Constructors, setters, and other methods

    public String getRole() {
		return u.getRole();
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
        return u.getEmail();
    }

	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public CustomUserDetail(User user) {
		this.u = user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(this.u.getRole()));
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return u.getPassword();
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return u.getUsername();
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public int getUserId() {
		// TODO Auto-generated method stub
		return u.getUserId();
	}


}