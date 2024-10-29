package com.example.demo.repository;

import java.util.List;

//CommentRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	@Query("SELECT c FROM Comment c WHERE c.recommendation_id = :r")
	List<Comment> allCommentsWithRecommendationId(@Param("r") int id);

//	@Query("DELETE FROM comments WHERE userId = :u")
//	void deleteCommentById(@Param("u")int userId);

}
