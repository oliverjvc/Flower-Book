package com.example.demo.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.dto.LoginRequest;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/auth")
//public class AuthController {
//	
//	@Autowired
//    private final AuthenticationManager authenticationManager;
//    
//	@Autowired
//	private JwtTokenProvider tokenProvider;  
//	
//    @Autowired
//    public AuthController(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
////    @PostMapping("/login")
////    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws AuthenticationException {
////        Authentication authentication = authenticationManager.authenticate(
////            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
////        );
////
////        String jwt = Jwts.builder()
////            .setSubject(authRequest.getUsername())
////            .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day validity
////            .signWith(SignatureAlgorithm.HS512, "SecretKeyToGenerateJWTs")
////            .compact();
////
////        return ResponseEntity.ok(new JwtResponse(jwt)); // Returning JWT as JSON
////    }
////    @PostMapping("/login")
////    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws AuthenticationException {
////        Authentication authentication = authenticationManager.authenticate(
////            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
////        );
////
////        String jwt = Jwts.builder()
////            .setSubject(authRequest.getUsername())
////            .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day validity
////            .signWith(SignatureAlgorithm.HS512, "SecretKeyToGenerateJWTs")
////            .compact();
////
////        // Return JWT in JSON format
////        return ResponseEntity.ok(new JwtResponse(jwt)); 	
////    }
//    
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = tokenProvider.generateToken(authentication);
//
//        return ResponseEntity.ok(new JwtResponse(jwt));
//    }
//
//    
//    public class JwtResponse {
//
//        private String token;
//
//        public JwtResponse(String token) {
//            this.token = token;
//        }
//
//        public String getToken() {
//            return token;
//        }
//
//        public void setToken(String token) {
//            this.token = token;
//        }
//    }
//
//
//
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
//
//    @PostMapping("/login")
//    public JwtResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
//        // Authenticate the user
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        // Set the authentication in the context
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Generate the JWT token
//        String jwt = jwtTokenProvider.generateToken(authentication);
//
//        // Return the response with the token
//        return new JwtResponse(jwt);
//    }
    
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
//    	System.out.println("\n login user evoked");
//        Authentication authentication = authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(
//                loginRequest.getUsername(), 
//                loginRequest.getPassword()
//            )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        
//        String jwt = jwtTokenProvider.generateToken(authentication);
//        System.out.println("kurcina");
//        return ResponseEntity.ok(new JwtResponse(jwt) + "ide gas");  // return token
//    }
    	
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("\n login user evoked");
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), 
                loginRequest.getPassword()
            )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtTokenProvider.generateToken(authentication);
        System.out.println("Token generated: " + jwt); // To verify if JWT is being generated
        return ResponseEntity.ok(new JwtResponse(jwt));  // Return token
    }

}


		
