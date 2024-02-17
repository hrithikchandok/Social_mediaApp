package com.self.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.self.blog.entity.Comment;
import com.self.blog.entity.Post;
import com.self.blog.exceptions.ResourceNotFoundException;
import com.self.blog.payloads.ApiResponse;
import com.self.blog.payloads.CommentDto;
import com.self.blog.repository.CommentRepo;
import com.self.blog.repository.PostRepo;
import com.self.blog.services.CommentService;

@Service
public class CommentServImpl implements CommentService{

	@Autowired
	  private CommentRepo commentRepo;
	
	@Autowired	
	private ModelMapper modelMapper;	
	@Autowired
	private PostRepo postRepo;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, int post_id) {
		// TODO Auto-generated method stub
		Post post=postRepo.findById(post_id).orElseThrow(()->new ResourceNotFoundException("Post","Id",post_id));
		Comment comment=modelMapper.map(commentDto,Comment.class);
		comment.setContent(commentDto.getContent());
		comment.setId(commentDto.getId());
		comment.setPost(post);
		
		commentRepo.save(comment);
		
		return modelMapper.map(comment, CommentDto.class);		
//		return null;
	}

	@Override
	public ResponseEntity<ApiResponse> delelteComment(int comment_id) {
		// TODO Auto-generated method stub
		 Comment comment=commentRepo.findById(comment_id).orElseThrow(()->new ResourceNotFoundException("COmment","Id", comment_id));
		 commentRepo.delete(comment);
		 
				 
				 return new ResponseEntity<>(new ApiResponse("Coment Delted SucessFully",true),HttpStatus.OK);
	}

}