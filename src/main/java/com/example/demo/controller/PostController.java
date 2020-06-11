package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable long id) {
        return postService.getPostById(id);
    }

    @GetMapping
    public Map<String, List<Post>> getAllPosts() {
        Map<String, List<Post>> response = new HashMap<>();
        response.put("postList", postService.getAllPosts());
        return response;
    }

    @PostMapping
    public Post postPost(@RequestBody Post post) {
        return postService.makePost(post);
    }

    @DeleteMapping("/{id}")
    public long deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return id;
    }


    @PutMapping("/{id}")
    public Post putPost(@PathVariable long id,
                        @RequestBody Post post) {
        return postService.updatePost(id, post);
    }
}
