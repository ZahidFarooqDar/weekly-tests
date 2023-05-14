package com.example.instagram.repository;

import com.example.instagram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Long> {
}
