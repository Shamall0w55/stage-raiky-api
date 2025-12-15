package com.example.blog.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Getter
@NoArgsConstructor
public class PostJpaEntity {
    @Id
    private String postID;
    private String title;
    private String content;

    public PostJpaEntity(String postID, String title, String content) {
        this.postID = postID;
        this.title = title;
        this.content = content;
    }
}
