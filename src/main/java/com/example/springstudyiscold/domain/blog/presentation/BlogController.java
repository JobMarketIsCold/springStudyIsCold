package com.example.springstudyiscold.domain.blog.presentation;

import com.example.springstudyiscold.domain.blog.domain.Blog;
import com.example.springstudyiscold.domain.blog.presentation.dto.request.CreateBlogDto;
import com.example.springstudyiscold.domain.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAll(){
        return ResponseEntity.ok(blogService.findAll());
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody CreateBlogDto dto){
        return ResponseEntity.ok(blogService.save(dto));
    }
}
