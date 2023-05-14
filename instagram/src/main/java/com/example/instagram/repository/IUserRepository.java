package com.example.instagram.repository;

import com.example.instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {

    User findFirstByEmail(String email);
}
