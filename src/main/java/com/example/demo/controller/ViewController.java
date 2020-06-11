package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @GetMapping("/postList.html")
    public ModelAndView renderPostListView() {
        return new ModelAndView("/postList");
    }

    @GetMapping("/post.html")
    public ModelAndView renderPostView() {
        return new ModelAndView("/post");
    }

    @GetMapping("/postDetail.html")
    public ModelAndView renderPostView(@RequestParam long id) {
        return new ModelAndView("/postDetail");
    }


    @GetMapping("/comment.html")
    public ModelAndView renderCommentView(@RequestParam long postId) {
        return new ModelAndView("/comment");
    }
}
