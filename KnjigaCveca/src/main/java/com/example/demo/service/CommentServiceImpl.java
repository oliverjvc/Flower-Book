// CommentServiceImpl.java
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.UserRepository;

import model.Comment;
import model.User;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }
    
    @Override
    public User getUserByName(String username) {
    	return userRepository.getByName(username);
    }
    
    @Override
	public List<Comment> getCommentsByRecommendationId(int id){
    	return commentRepository.allCommentsWithRecommendationId(id);
    }

}
