package com.self.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.self.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{
}
