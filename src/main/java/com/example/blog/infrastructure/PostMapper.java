package com.example.blog.infrastructure;

import com.example.blog.domain.entity.Post;
import com.example.blog.domain.value_object.PostContent;
import com.example.blog.domain.value_object.PostTitle;

import java.util.UUID;

public class PostMapper {
    public static Post toDomain(PostJpaEntity postJpaEntity){
        PostTitle title = new PostTitle(postJpaEntity.getTitle());
        PostContent content = new PostContent(postJpaEntity.getContent());
        return new Post(UUID.fromString(postJpaEntity.getPostID()), title, content);
    }
    public static PostJpaEntity toEntity(Post post){
        return new PostJpaEntity(
                post.getPostID().toString(),
                post.getTitle().getTitle(),
                post.getContent().getContent());
    }
}
