package com.example.tp.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.tp.entity.Posts;
import com.example.tp.service.PostsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Posts> getPostsById(@PathVariable("idPosts") Long id) {
        Posts posts = postsService.findById(id);
        if (posts != null) {
            return ResponseEntity.status(HttpStatus.OK).body(posts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posts> updatePosts(@PathVariable Long id, @Valid @RequestBody Posts posts) {
        Posts posts1 = postsService.update(id,posts);
        return ResponseEntity.ok(posts1);
    }

    @PostMapping
    public ResponseEntity<Posts> createPost(@Valid @RequestBody Posts posts) {
        try {
            return ResponseEntity.ok(postsService.save(posts));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosts(@PathVariable Long id) {
        postsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
