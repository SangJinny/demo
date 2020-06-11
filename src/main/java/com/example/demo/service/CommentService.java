package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentListByPostId(long postId) {
        return commentRepository.findAllByPostId(postId);
    }
    public Comment makeComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteAllComment(long postId) {
        commentRepository.deleteAllByPostId(postId);
    }
}
