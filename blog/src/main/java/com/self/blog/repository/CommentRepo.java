package com.self.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.self.blog.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer>
{
	
}
