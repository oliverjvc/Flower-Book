package com.example.demo.rest;

import java.security.SecureRandom;
import java.util.Base64;

public class JwtSecretGenerator {
    public static String generateSecureSecret() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[64]; // 512 bits
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static void main(String[] args) {
        String secureSecret = generateSecureSecret();
        System.out.println("Generated JWT Secret: " + secureSecret);
    }
}