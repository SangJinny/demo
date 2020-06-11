package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;

@RestController
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/posts/{id}/comments")
    public List<Comment> getAllComments(@PathVariable(name = "id") long postId) {
        return commentService.getCommentListByPostId(postId);
    }

    @PostMapping("/posts/{id}/comments")
    public Comment postComment(@PathVariable(name = "id") long postId,
                       @RequestBody Comment comment) {
    	comment.setPostId(postId);
        return commentService.makeComment(comment);
    }
}
