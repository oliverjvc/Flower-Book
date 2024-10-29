package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.User;

@Service
public class TokenService {
//	public String generateTokenForUser(User user) {
//	    // Use the user's username
//	    String username = user.getUsername();
//	    // Define the secret and expiration if not already defined
//	    String jwtSecret = JwtSecretGenerator.generateSecureSecret();
//	    long jwtExpirationMs = 86400000; // 24 hours in milliseconds
//
//	    // Generate and return the JWT token
//	    return Jwts.builder()
//	            .setSubject(username)
//	            .setIssuedAt(new Date())
//	            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
//	            .signWith(SignatureAlgorithm.HS512, jwtSecret)
//	            .compact();
//	}
//	
	@Value("${jwt.secret}")
    private String secretKey;

	public String generateTokenForUser(User user) {
	    return Jwts.builder()
	        .setSubject(user.getUsername())
	        .claim("role", user.getRole())
	        .signWith(SignatureAlgorithm.HS256, secretKey.getBytes()) // secretKey is your signing key
	        .compact();
	}

	
}
