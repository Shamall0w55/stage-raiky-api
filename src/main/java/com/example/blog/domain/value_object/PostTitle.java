package com.example.blog.domain.value_object;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class PostTitle {
    private final String title;

    public PostTitle(String title) {
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (title.length() > 100){
            throw new IllegalArgumentException("Title cannot exceeds 100 characters");
        }
        this.title = title;
    }
}
