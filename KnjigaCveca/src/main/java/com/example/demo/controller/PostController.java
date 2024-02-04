package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.RecommendationServiceImpl;

import model.Recommendation;

//YourController.java
@Controller
@RequestMapping("/KnjigaCveca") // Add this annotation at the class level
public class PostController {

	@Autowired
	private RecommendationServiceImpl recommendationService;

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

	//Add this method in your controller
	@GetMapping("/showAllRecommendations")
	public String showAllRecommendations(Model model) {
		List<Recommendation> recommendations = recommendationService.getAllRecommendations();
		model.addAttribute("recommendations", recommendations);
		return "posts"; // Replace with the actual JSP file name
	}

	// Other controller methods...
}
