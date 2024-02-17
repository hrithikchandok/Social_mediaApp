package com.self.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.self.blog.entity.User;

import jakarta.validation.constraints.Email;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	     Optional<User>findByEmail(String email);

}
