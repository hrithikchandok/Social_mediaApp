package com.self.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.self.blog.entity.User;
import com.self.blog.repository.UserRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService
{
     @Autowired
     private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		   User user=  userRepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Please Enter Right Credentails-User Not Found"));		  
		  return user;
	}

}