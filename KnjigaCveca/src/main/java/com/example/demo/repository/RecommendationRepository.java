package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {
    // Add custom query methods if needed
	
	@Query("SELECT r FROM Recommendation r WHERE r.id = :recommendationId")
    Recommendation getRecommendationById(@Param("recommendationId") int recommendationId);
	
	@Query("SELECT r FROM Recommendation r")
	List<Recommendation> gettAllRecommendation();
}
