package com.example.springstudyiscold.domain.blog.service;

import com.example.springstudyiscold.domain.blog.domain.Blog;
import com.example.springstudyiscold.domain.blog.presentation.dto.request.CreateBlogDto;
import com.example.springstudyiscold.domain.blog.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Blog save(CreateBlogDto dto) {
        return blogRepository.save(dto.toEntity());
    }
}
