package com.example.springstudyiscold.domain.blog.repository;


import com.example.springstudyiscold.domain.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long>{
}
