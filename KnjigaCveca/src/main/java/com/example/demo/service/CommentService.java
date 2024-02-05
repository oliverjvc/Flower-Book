// CommentService.java
package com.example.demo.service;

import java.util.List;

import model.Comment;
import model.User;

public interface CommentService {
    void saveComment(Comment comment);
    User getUserByName(String username);
    List<Comment> getCommentsByRecommendationId(int id);
}
