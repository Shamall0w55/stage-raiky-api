package com.example.blog.domain.entity;

import com.example.blog.domain.value_object.PostContent;
import com.example.blog.domain.value_object.PostTitle;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {
    @EqualsAndHashCode.Include
    private final UUID postID;
    private PostTitle title;
    private PostContent content;

    public Post(PostTitle title, PostContent content) {
        this.postID = UUID.randomUUID();
        this.title = title;
        this.content = content;
    }

    public void updateTitle(PostTitle newTitle){
        this.title = newTitle;
    }

    public void updateContent(PostContent newContent){
        this.content = newContent;
    }
}