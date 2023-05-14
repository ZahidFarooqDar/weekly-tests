package com.example.instagram.service;

import com.example.instagram.model.Post;
import com.example.instagram.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    IPostRepo postRepo;
    public void addPost(Post post) {

        postRepo.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }
}
