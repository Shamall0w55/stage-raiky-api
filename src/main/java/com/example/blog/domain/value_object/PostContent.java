package com.example.blog.domain.value_object;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class PostContent {
    private final String content;

    public  PostContent(String content) {
        if(content == null || content.isBlank()){
            throw new IllegalArgumentException("Post content cannot be null or empty");
        }
        if (content.length() > 500){
            throw new IllegalArgumentException("Post content cannot exceeds 500 characters");
        }
        this.content = content;
    }
}
