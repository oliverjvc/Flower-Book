package com.example.demo.service;

import java.util.List;

import model.Recommendation;

public interface RecommendationService {
	
	List<Recommendation>getAllRecommendations();
	
    Recommendation saveRecommendation(Recommendation recommendation);

	Recommendation getRecommendationById(int recommendationId);
}
