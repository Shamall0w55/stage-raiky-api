package com.example.blog.presentation;

import com.example.blog.application.PostUseCase;
import com.example.blog.domain.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostUseCase postUseCase;

    //create
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDto) {
        Post post = postUseCase.createPost(postDto.getPostTitle(), postDto.getPostContent());
        return new ResponseEntity<>(post,HttpStatus.CREATED);
    }

    //find by ID
    @GetMapping("{id}")
    public ResponseEntity<Post> getPostById(@PathVariable UUID id) {
        return postUseCase.findPostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //find all
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postUseCase.findAll());
    }

    //update
    @PutMapping
    public ResponseEntity<Post> updatePost(@PathVariable UUID id, @RequestBody PostDTO postDto) {
        Post updatedPost = postUseCase.updatePost(id, postDto.getPostTitle(), postDto.getPostContent());
        return ResponseEntity.ok(updatedPost);
    }

    //delete
    @DeleteMapping
    public ResponseEntity<Void> deletePost(@PathVariable UUID id) {
        postUseCase.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
