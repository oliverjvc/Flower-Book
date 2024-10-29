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
import com.example.demo.service.StoreServiceImpl;

import jakarta.servlet.http.HttpSession;
import model.Comment;
import model.Recommendation;
import model.Store;
import model.User;

@Controller
@RequestMapping("/KnjigaCveca") 
public class PostController {

	@Autowired
	private RecommendationServiceImpl recommendationService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CommentServiceImpl commentServiceImpl;
	
	@Autowired
	private StoreServiceImpl storeService;

	@PostMapping("/addComment")
	public String addComment(@RequestParam("commentText") String commentText,
			@RequestParam("recommendationId") int recommendationId, HttpSession session) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName(); 

		int userId = 0;

		User u = commentServiceImpl.getUserByName(name);
		userId = u.getUserId();
		if (userId == 0) {
			return "redirect:/login"; 
		}

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
		int recommendationId = 1; 
		Recommendation recommendation = recommendationService.getRecommendationById(recommendationId);

		if (recommendation != null) {
			model.addAttribute("recommendationText", recommendation.getRecommendationText());
		} else {
			model.addAttribute("recommendationText", "No recommendation found");
		}

		return "show_recommendation"; 
	}

	@GetMapping("/")
	public String posts(Model model) {
		List<Recommendation> recommendations = recommendationService.getAllRecommendations();
		model.addAttribute("recommendations", recommendations);
		return "posts";
	}

	@GetMapping("/showAllRecommendations")
	public String showAllRecommendations(Model model) {
		List<Recommendation> recommendations = recommendationService.getAllRecommendations();
		model.addAttribute("recommendations", recommendations);
		return "posts"; 
	}
	
		@GetMapping("/showAllRecommendations2")
		public String showAllRecommendations2(Model model) {
			List<Recommendation> recommendations = recommendationService.getAllRecommendations();
			model.addAttribute("recommendations", recommendations);
			return "home"; 
		}

	@GetMapping("/showIndividualRecommendation")
	public String showIndividualRecommendation(@RequestParam("id") int id, Model model) {
		Recommendation recommendation = recommendationService.getRecommendationById(id);

		if (recommendation != null) {
			model.addAttribute("individualRecommendation", recommendation);

			List<Comment> comments = commentService.getCommentsByRecommendationId(recommendation.getRecommendationId());
			model.addAttribute("comments", comments);

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication != null && authentication.isAuthenticated()) {
				Object principal = authentication.getPrincipal();
				if (principal instanceof User) {
					User userDetails = (User) principal;
					model.addAttribute("yourUserId", userDetails.getUserId());
				}
			}
		} else {
			return "redirect:/KnjigaCveca/posts"; 
		}

		return "showIndividualRecommendation"; 
	}

	@PostMapping("/showComments")
	public String showComments(@RequestParam("recommendationId") int recommendationId, Model model) {
		List<Comment> comments = commentService.getCommentsByRecommendationId(recommendationId);
		if (comments != null) {
			model.addAttribute("comments", comments);
		}
		return "showIndividualRecommendation"; 
	}
	
	   @GetMapping("/stores")
	    public String getAllStores(Model model) {
	        List<Store> stores = storeService.getAllStores();
	        model.addAttribute("stores", stores);
	        return "storesAll";
	    }
}
