package com.example.instagram.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String postData;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
