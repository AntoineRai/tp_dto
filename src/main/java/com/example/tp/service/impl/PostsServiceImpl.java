package com.example.tp.service.impl;

import com.example.tp.entity.Posts;
import com.example.tp.repository.PostsRepository;
import com.example.tp.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsRepository postsRepository;

    @Override
    public Posts save(Posts entity) {
        return postsRepository.save(entity);
    }

    @Override
    public Posts findById(Long aLong) {
        return postsRepository.findById(aLong).orElseThrow(() -> new RuntimeException("Posts not Found"));
    }

    @Override
    public List<Posts> findAll() {
        return postsRepository.findAll();
    }

    @Override
    public Posts update(Long aLong, Posts entity) {
        Posts posts = findById(aLong);
        posts.setComments(entity.getComments());
        posts.setTitle(entity.getTitle());
        posts.setDescription(entity.getDescription());
        posts.setContent(entity.getContent());
        return postsRepository.save(posts);
    }

    @Override
    public void deleteById(Long aLong) {
        Posts posts = findById(aLong);
        posts.getComments().forEach(comments -> {
            comments.setPosts(null);
        });
        posts.getComments().clear();
        postsRepository.save(posts);
        postsRepository.delete(posts);
    }
}
