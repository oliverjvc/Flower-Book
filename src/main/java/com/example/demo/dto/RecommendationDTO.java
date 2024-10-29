package com.example.demo.dto;

import model.User;

public class RecommendationDTO {

	private User user; // Instead of storing userId, store the whole User object
	
	 private Integer userId;  // Instead of User, store userId

	    // Other fields...

	    public Integer getUserId() {
	        return userId;
	    }

	    public void setUserId(Integer userId) {
	        this.userId = userId;
	    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private String recommendationText;

	public String getRecommendationText() {
		return recommendationText;
	}

	public void setRecommendationText(String recommendationText) {
		this.recommendationText = recommendationText;
	}

}
