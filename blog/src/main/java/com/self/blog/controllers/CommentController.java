package com.self.blog.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.dependency.AbstractBeansOfTypeDatabaseInitializerDetector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self.blog.entity.Comment;
import com.self.blog.payloads.ApiResponse;
import com.self.blog.payloads.CommentDto;
import com.self.blog.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	  private CommentService comService; 
	 
	@Autowired
	private ModelMapper modelMapper;	 
	
	  @PostMapping("/comment/{post_id}")
	 public ResponseEntity<CommentDto> createComment( @RequestBody CommentDto commentDto,@PathVariable int post_id)
	 {
//	   Comment comment=modelMapper.map(commentDto, Comment.class);
	      CommentDto tempCommentDto= comService.createComment(commentDto, post_id);    
	      return new ResponseEntity<>(tempCommentDto,HttpStatus.CREATED);
	      }
	  
	  @DeleteMapping("comment/{comment_id}")
	  public ResponseEntity<ApiResponse> deleteComment(@PathVariable int comment_id)
	  {
		   return  comService.delelteComment(comment_id);
	  }
}
