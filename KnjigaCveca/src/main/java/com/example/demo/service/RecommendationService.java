package com.example.demo.service;

import java.util.List;

import model.Recommendation;

public interface RecommendationService {
	
	List<Recommendation>getAllRecommendations();
	
    void saveRecommendation(Recommendation recommendation);

	Recommendation getRecommendationById(int recommendationId);
}
