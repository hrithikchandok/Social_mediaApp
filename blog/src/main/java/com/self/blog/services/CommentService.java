package com.self.blog.services;

import org.springframework.http.ResponseEntity;

import com.self.blog.payloads.ApiResponse;
import com.self.blog.payloads.CommentDto;

public interface CommentService 
{
	 CommentDto createComment(CommentDto commentDto , int post_id);
	 ResponseEntity<ApiResponse>delelteComment(int comment_id);

}
