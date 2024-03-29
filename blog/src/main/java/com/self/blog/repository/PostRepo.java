package com.self.blog.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.self.blog.entity.Category;
import com.self.blog.entity.Post;
import com.self.blog.entity.User;
//import com.self.blog.payloads.PostDTO;


public interface PostRepo extends JpaRepository<Post,Integer>
{
	// abhi post type ka le rakha hai 
	List<Post> findByCategory(Category category);
	List<Post>findByUser(User user);
	List<Post>findByTitleContaining(String Keywoard);	
//	@Override
//	Page<Post> findAll(Pageable pageable);
}