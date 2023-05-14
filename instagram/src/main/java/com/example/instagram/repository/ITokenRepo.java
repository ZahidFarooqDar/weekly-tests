package com.example.instagram.repository;

import com.example.instagram.model.AuthenticationToken;
import com.example.instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findByUser(User user);

    AuthenticationToken findFirstByToken(String token);
}
