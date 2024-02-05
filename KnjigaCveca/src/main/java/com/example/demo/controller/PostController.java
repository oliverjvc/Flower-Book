package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.CommentService;
import com.example.demo.service.CommentServiceImpl;
import com.example.demo.service.RecommendationServiceImpl;

import jakarta.servlet.http.HttpSession;
import model.Comment;
import model.Recommendation;
import model.User;

//YourController.java
@Controller
@RequestMapping("/KnjigaCveca") // Add this annotation at the class level
public class PostController {

	@Autowired
	private RecommendationServiceImpl recommendationService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CommentServiceImpl commentServiceImpl;

	@PostMapping("/addComment")
	public String addComment(@RequestParam("commentText") String commentText,
			@RequestParam("recommendationId") int recommendationId, HttpSession session) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName(); // This assumes the userId is stored as the username
		// Retrieve userId from the session

		int userId = 0;

		User u = commentServiceImpl.getUserByName(name);
		userId = u.getUserId();
		// Check if userId is not available in the session
		if (userId == 0) {
			// Handle the case where userId is not found in the session
			// You may want to redirect to a login page or take appropriate action
			return "redirect:/login"; // Adjust the redirect URL as needed
		}

		// Print or log the userId for debugging
		System.out.println("User ID: " + userId);

		Comment comment = new Comment();
		comment.setCommentText(commentText);
		comment.setRecommendation_id(recommendationId);
		comment.setUserId(userId);
		comment.setUserName(name);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		comment.setTimestamp(timestamp);
		commentService.saveComment(comment);

		return "redirect:/KnjigaCveca/showIndividualRecommendation?id=" + recommendationId;
	}

	@GetMapping("/showRecommendation")
	public String showRecommendation(Model model) {
		int recommendationId = 1; // Replace with the actual ID you want to display
		Recommendation recommendation = recommendationService.getRecommendationById(recommendationId);

		if (recommendation != null) {
			model.addAttribute("recommendationText", recommendation.getRecommendationText());
		} else {
			model.addAttribute("recommendationText", "No recommendation found");
		}

		return "show_recommendation"; // Replace with the actual JSP file name
	}

	@GetMapping("/")
	public String posts(Model model) {
		List<Recommendation> recommendations = recommendationService.getAllRecommendations();
		model.addAttribute("recommendations", recommendations);
		return "posts";
	}

	// Add this method in your controller
	@GetMapping("/showAllRecommendations")
	public String showAllRecommendations(Model model) {
		List<Recommendation> recommendations = recommendationService.getAllRecommendations();
		model.addAttribute("recommendations", recommendations);
		return "posts"; // Replace with the actual JSP file name
	}
	
	// Add this method in your controller
		@GetMapping("/showAllRecommendations2")
		public String showAllRecommendations2(Model model) {
			List<Recommendation> recommendations = recommendationService.getAllRecommendations();
			model.addAttribute("recommendations", recommendations);
			return "home"; // Replace with the actual JSP file name
		}

	@GetMapping("/showIndividualRecommendation")
	public String showIndividualRecommendation(@RequestParam("id") int id, Model model) {
		Recommendation recommendation = recommendationService.getRecommendationById(id);

		if (recommendation != null) {
			model.addAttribute("individualRecommendation", recommendation);

			// Fetch comments for the recommendation from CommentRepository
			List<Comment> comments = commentService.getCommentsByRecommendationId(recommendation.getRecommendationId());
			model.addAttribute("comments", comments);

			// Add userId to the model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication != null && authentication.isAuthenticated()) {
				Object principal = authentication.getPrincipal();
				if (principal instanceof User) {
					User userDetails = (User) principal;
					model.addAttribute("yourUserId", userDetails.getUserId());
				}
			}
		} else {
			// Handle case where recommendation is not found
			// You might want to redirect or show an error message
			return "redirect:/KnjigaCveca/posts"; // Redirect to the posts page
		}

		return "showIndividualRecommendation"; // Return the JSP page
	}

	@PostMapping("/showComments")
	public String showComments(@RequestParam("recommendationId") int recommendationId, Model model) {
		List<Comment> comments = commentService.getCommentsByRecommendationId(recommendationId);
		if (comments != null) {
			model.addAttribute("comments", comments);
		}
		return "showIndividualRecommendation"; // Adjust the view name as needed
	}
}
