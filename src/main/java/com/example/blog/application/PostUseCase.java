package com.example.blog.application;

import com.example.blog.domain.entity.Post;
import com.example.blog.domain.repository.PostRepository;
import com.example.blog.domain.value_object.PostContent;
import com.example.blog.domain.value_object.PostTitle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PostUseCase {
    private final PostRepository postRepository;

    public PostUseCase(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public  Post createPost(String titleStr, String contentStr){
        PostTitle title = new PostTitle(titleStr);
        PostContent content = new PostContent(contentStr);
        Post post = new Post(title,content);
        return postRepository.save(post);
    }

    public Optional<Post> findPostById(UUID postId){
        return postRepository.findById(postId);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post updatePost(UUID postId, String titleStr, String contentStr){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post Not Found"));
        PostTitle newTitle = new PostTitle(titleStr);
        PostContent newContent = new PostContent(contentStr);
        post.updateTitle(newTitle);
        post.updateContent(newContent);
        return postRepository.save(post);
    }

    public void deletePost(UUID postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post Not Found"));
        postRepository.deleteById(postId);
    }
}
