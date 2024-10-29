package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.RecommendationRepository;

import model.Recommendation;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository; // Assuming you have a RecommendationRepository

    @Override
    public Recommendation saveRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }
    
    public Recommendation getRecommendationById(Integer id) {
        return recommendationRepository.findById(id).orElse(null);
    }
    
	public Recommendation getRecommendationById(int recommendationId) {
		return recommendationRepository.getRecommendationById(recommendationId);
	}
	
	public List<Recommendation>getAllRecommendations(){
		return recommendationRepository.gettAllRecommendation();
	}

}
