package com.example.instagram.controller;

import com.example.instagram.model.Post;
import com.example.instagram.repository.IPostRepo;
import com.example.instagram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    PostService postService;


    @PostMapping()
    void savePost(@RequestBody Post post)
    {
        postService.addPost(post);
    }
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
