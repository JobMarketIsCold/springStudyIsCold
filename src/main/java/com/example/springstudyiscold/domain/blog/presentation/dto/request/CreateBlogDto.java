package com.example.springstudyiscold.domain.blog.presentation.dto.request;

import com.example.springstudyiscold.domain.blog.domain.Blog;

public record CreateBlogDto (
   String title,
   String content,
   String author
){

    public Blog toEntity(String title, String content, String author) {
    return Blog.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();
    }
}
