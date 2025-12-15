package com.example.blog.domain.repository;

import com.example.blog.domain.entity.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(UUID postId);
    List<Post> findAll();
    void  deleteById(UUID postId);
}