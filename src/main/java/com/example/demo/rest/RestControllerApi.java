package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.dto.RecommendationDTO;
import com.example.demo.dto.RestLoginDTO;
import com.example.demo.dto.RestRegisterDTO;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetail;
import com.example.demo.service.CommentService;
import com.example.demo.service.RecommendationService;
import com.example.demo.service.UserService;
import java.time.LocalDateTime;
import java.sql.Timestamp;


import java.sql.Time;
import java.util.Base64;

import model.Comment;
import model.Recommendation;
import model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/api")
public class RestControllerApi {

	@Autowired
	private CommentService commentService;

	@Autowired
	private RecommendationService recommendationService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;  // Inject the repository
	
	@Autowired
	private RecommendationRepository recommendationRepository;


	private final AuthenticationManager authenticationManager;
	private final UserService us;
	private final TokenService ts;

	@Autowired
	public RestControllerApi(AuthenticationManager authenticationManager, UserService us, TokenService ts) {
		this.authenticationManager = authenticationManager;
		this.us = us;
		this.ts = ts;
	}

	// Get all recommendations
	@GetMapping("/recommendations")
	public ResponseEntity<List<Recommendation>> getAllRecommendations() {
		List<Recommendation> recommendations = recommendationService.getAllRecommendations();
		return ResponseEntity.ok(recommendations);
	}

	// Get a recommendation by ID
	@GetMapping("/recommendations/{id}")
	public ResponseEntity<Recommendation> getRecommendationById(@PathVariable int id) {
		Recommendation recommendation = recommendationService.getRecommendationById(id);
		if (recommendation != null) {
			return ResponseEntity.ok(recommendation);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Post a comment to a recommendation
//    @PostMapping("/recommendations/{id}/comments")
//    public ResponseEntity<Comment> postComment(@PathVariable int id, @RequestBody Comment comment, @RequestParam String username) {
//        User user = userService.getUserByName(username);
//        if (user != null) {
//            comment.setRecommendationId(id);
//            comment.setUserId(user.getId());
//            commentService.saveComment(comment);
//            return ResponseEntity.ok(comment);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }

	// Get comments for a recommendation by recommendation ID
	@GetMapping("/recommendations/{id}/comments")
	public ResponseEntity<List<Comment>> getCommentsByRecommendationId(@PathVariable int id) {
		List<Comment> comments = commentService.getCommentsByRecommendationId(id);
		return ResponseEntity.ok(comments);
	}

	// Register a new user
	@PostMapping("/users/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		boolean isRegistered = userService.registerUser(user, false);
		if (isRegistered) {
			return ResponseEntity.ok("User registered successfully.");
		} else {
			return ResponseEntity.badRequest().body("User registration failed. Username or email already exists.");
		}
	}

//	// Get user role by username
//	@GetMapping("/users/{username}/role")
//	public ResponseEntity<String> getUserRole(@PathVariable String username) {
//		String role = userService.getRole(username);
//		if (role != null) {
//			return ResponseEntity.ok(role);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//
//	@PostMapping("/login")
//	public ResponseEntity<LoginResponseDTO> login(@RequestBody RestLoginDTO restLogin) {
//	    try {
//	        // Authenticate the user
//	        Authentication authentication = authenticationManager.authenticate(
//	            new UsernamePasswordAuthenticationToken(restLogin.getUsername(), restLogin.getPassword())
//	        );
//
//	        // Set the authentication in the SecurityContext
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//	        // Generate JWT token
//	        User user = (User) authentication.getPrincipal();
//	        String jwt = ts.generateTokenForUser(user);
//
////	        // Get user details
////	        List<String> roles = user.getAuthorities().stream()
////	            .map(GrantedAuthority::getAuthority)
////	            .collect(Collectors.toList());
//
//	        // Create and return the response
//	        LoginResponseDTO responseDTO = new LoginResponseDTO(
//	            jwt,
//	            user.getUserId(),
//	            user.getUsername(),
//	            user.getEmail()
////	            roles
//	        );
//
//	        return ResponseEntity.ok(responseDTO);
//	    } catch (AuthenticationException e) {
//	        // Authentication failed
//	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//	            .body(new LoginResponseDTO("Authentication failed", null, null, null));
//	    }
//	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody RestLoginDTO restLogin)
			throws NoSuchFieldException, SecurityException {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(restLogin.getUsername(), restLogin.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		if (authentication == null) {
			return ResponseEntity.badRequest().body(new LoginResponseDTO("FAIL", null));
		}

		if (authentication.isAuthenticated()) {
			// Fetch the user by username and generate a token for the user
			User user = us.findByUsername(restLogin.getUsername());
			String token = ts.generateTokenForUser(user);
			return ResponseEntity.ok().body(new LoginResponseDTO(token, authentication.getPrincipal()));
		} else {
			return ResponseEntity.badRequest().body(new LoginResponseDTO("FAIL", null));
		}
	}
	

	@PostMapping("/register")
	public ResponseEntity<LoginResponseDTO> register(@RequestBody RestRegisterDTO restRegister) {
//		if (us.findByUsername(restRegister.getUsername()) != null) {
//	        return ResponseEntity.badRequest().body(new LoginResponseDTO("Username already exists", null));
//	    }
//		byte[] decoded = Base64.getDecoder().decode(restRegister.getPassword());
//		String encoded = Base64.getEncoder().encodeToString(decoded);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User k = new User();
		k.setEmail(restRegister.getEmail());
		k.setUsername(restRegister.getUsername());
		System.out.println("1");
//		k.setRole(restRegister.getRole());
		k.setRole("ROLE_ADMIN");
		String encodedPassword = passwordEncoder.encode(restRegister.getPassword());
	    k.setPassword(encodedPassword); // Store the BCrypt-encoded password
		try {
			us.save(k);
			System.out.println("User saved successfully.");
		} catch (Exception e) {
			System.out.println("Error saving user: " + e.getMessage());
			return ResponseEntity.badRequest().body(new LoginResponseDTO("FAIL", null));
		}
		// Authenticate the new user
	    try {
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(restRegister.getUsername(), restRegister.getPassword()));
	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        // Get CustomUserDetail object from authentication
	        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();

	        // If you need to generate the token based on your `User` entity, fetch the user
	        User authenticatedUser = us.findByUsername(customUserDetail.getUsername());
	        
	        // Generate JWT token for the authenticated user
	        String token = ts.generateTokenForUser(authenticatedUser);

	        // Return the token and user details
	        return ResponseEntity.ok().body(new LoginResponseDTO(token, authenticatedUser));
	    } catch (BadCredentialsException e) {
	        System.out.println("Invalid credentials: " + e.getMessage());
	        return ResponseEntity.badRequest().body(new LoginResponseDTO("FAIL", null));
	    } catch (Exception e) {
	        System.out.println("Authentication error: " + e.getMessage());
	        return ResponseEntity.badRequest().body(new LoginResponseDTO("FAIL", null));
	    }
	}
	
//	@PostMapping("/recommendations")
//	public ResponseEntity<Recommendation> createRecommendation(@RequestBody Recommendation recommendation) {
//	    Recommendation createdRecommendation = recommendationService.saveRecommendation(recommendation);
//	    return ResponseEntity.status(HttpStatus.CREATED).body(createdRecommendation);
//	}
	
//	@PostMapping("recommendations")
//	public ResponseEntity<Recommendation> createRecommendation(@RequestBody RecommendationDTO recommendationDTO) {
//	    // Ensure the user_id exists
//		Optional<User> user = userRepository.findById(recommendationDTO.getUser().getUserId());
//		Recommendation newRecommendation = new Recommendation();
//		if (user.isPresent()) {
//		    newRecommendation.setRecommendationText(recommendationDTO.getRecommendationText());
//		    newRecommendation.setUserId(user.get().getUserId());  // Set the entire User object
//		    recommendationRepository.save(newRecommendation);
//		    return ResponseEntity.status(HttpStatus.CREATED).body(newRecommendation);
//		}
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(newRecommendation);


//	    Recommendation newRecommendation = new Recommendation();
//	    newRecommendation.setRecommendationText(recommendationDTO.getRecommendationText());
//	    newRecommendation.setUserId(user.get().getUserId());  // Set the user object
	    
//	    recommendationRepository.save(newRecommendation);
//	    return ResponseEntity.status(HttpStatus.CREATED).body(newRecommendation);
//	}
	
	@PostMapping("/recommendations")
	public ResponseEntity<Recommendation> createRecommendation(@RequestBody RecommendationDTO recommendationDTO) {
	    Integer userId = recommendationDTO.getUserId();  // Get userId from DTO

	    if (userId == null) {
	        return ResponseEntity.badRequest().body(null);  // Handle case where userId is null
	    }

	    Optional<User> userOptional = userRepository.findById(userId);
	    if (!userOptional.isPresent()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Handle case where user is not found
	    }

	    Recommendation newRecommendation = new Recommendation();
	    newRecommendation.setRecommendationText(recommendationDTO.getRecommendationText());
	    newRecommendation.setUserId(userOptional.get().getUserId());  // Set the User object
	 // Assuming newRecommendation is an instance of a class with a setTimestamp method
	    newRecommendation.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));

	    // Save the new recommendation using the repository
	    Recommendation savedRecommendation = recommendationRepository.save(newRecommendation);

	    return ResponseEntity.status(HttpStatus.CREATED).body(savedRecommendation);
	}

}


