package com.example.springstudyiscold.domain.blog.presentation.dto.request;

import com.example.springstudyiscold.domain.blog.domain.Blog;

public record CreateBlogDto (
   String title,
   String content,
   String author
){

    public Blog toEntity() {
        return Blog.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .build();
    }
}
