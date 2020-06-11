package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CustomException;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class PostService {

    private PostRepository postRepository;
    private CommentService commentService;

    @Autowired
    public PostService(PostRepository postRepository,
                       CommentService commentService) {
        this.postRepository = postRepository;
        this.commentService = commentService;
    }

    public Post getPostById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow( () -> new CustomException("Post is not found"));
        post.setCommentList(commentService.getCommentListByPostId(id)); // @Transit으로 선언된 필드에 주입.
        return post;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post makePost(Post post) {
        return postRepository.save(post);
    }

    @Transactional // 두개의 테이블에 DELETE 연산이 들어가므로 하나의 트랜잭션으로 묶어줍니다.
    public void deletePost(long id) {
        postRepository.deleteById(id);
        commentService.deleteAllComment(id);
    }

    public Post updatePost(long id, Post post) {
        Post oldPost = postRepository.findById(id)
        		.orElseThrow(() -> new CustomException("Post is not found"));
        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());
        return postRepository.save(oldPost);
    }
}
