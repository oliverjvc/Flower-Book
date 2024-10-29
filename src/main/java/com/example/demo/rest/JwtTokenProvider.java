package com.example.demo.rest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    //@Value("${app.jwtSecret}")
    private String jwtSecret = "oliver";

    //@Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs = 86400000;

    // Generate the JWT token based on user authentication details
    public String generateToken(Authentication authentication) {
        //UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        String username = authentication.getName();
        System.out.println("ima nade");

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // Validate the JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // Log or handle token validation errors
        }
        return false;
    }

    // Get the username from the token
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
