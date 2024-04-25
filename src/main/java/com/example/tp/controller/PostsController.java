package com.example.tp.controller;

import com.example.tp.entity.Posts;
import com.example.tp.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @GetMapping()
    public List<Posts> getAllPosts() {
        return postsService.findAll();
    }
}
