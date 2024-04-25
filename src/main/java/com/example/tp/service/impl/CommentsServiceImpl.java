package com.example.tp.service.impl;

import com.example.tp.entity.Comments;
import com.example.tp.repository.CommentsRepository;
import com.example.tp.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public Comments save(Comments entity) {
        return commentsRepository.save(entity);
    }

    @Override
    public Comments findById(Long aLong) {
        return commentsRepository.findById(aLong).orElseThrow(() -> new RuntimeException("Comment not Found"));
    }

    @Override
    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }

    @Override
    public Comments update(Long aLong, Comments entity) {
        Comments comments = findById(aLong);
        comments.setName(entity.getName());
        comments.setPosts(entity.getPosts());
        comments.setBody(entity.getBody());
        comments.setEmail(entity.getEmail());
        return commentsRepository.save(comments);
    }

    @Override
    public void deleteById(Long aLong) {
        Comments comments = findById(aLong);
        commentsRepository.delete(comments);
    }
}
