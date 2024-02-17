package com.self.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//import org.hibernate.query.Page;
//imp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.self.blog.entity.Category;
import com.self.blog.entity.Post;
import com.self.blog.entity.User;
import com.self.blog.exceptions.ResourceNotFoundException;
import com.self.blog.payloads.ApiResponse;
import com.self.blog.payloads.PostDTO;
import com.self.blog.repository.CategoryRepo;
import com.self.blog.repository.PostRepo;
import com.self.blog.repository.UserRepo;
import com.self.blog.services.PostService;
@Service
public class PostServiceImpl implements PostService{
@Autowired
	 private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private CategoryRepo categoryRepo;
    
    
    @Override
	public PostDTO createPost(PostDTO postDTO,Integer cat_id,Integer user_id){
		// TODO Auto-generated method stub
    User  user=userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User","Id", user_id));    	
    Category category=categoryRepo.findById(cat_id).orElseThrow(()->new ResourceNotFoundException("User","Id", cat_id));
    
    Post post= 	modelMapper.map(postDTO,Post.class);	
    Date temp=new Date();
    post.setAddedDate(temp);    
    post.setImage("default.png");
    post.setUser(user);
    post.setCategory(category);  
         Post ans= postRepo.save(post);
         
	return modelMapper.map(ans,PostDTO.class);
        
	}

	
    

	@Override
	public ResponseEntity<ApiResponse>deletePost(Integer post_id) 
	{
	   Post post=postRepo.findById(post_id).orElseThrow(()->new ResourceNotFoundException("post", "id", post_id));  
	   postRepo.delete(post);
	   return new ResponseEntity<>(new ApiResponse("Post Deleted SuccesFully",true),HttpStatus.OK);
	}

	@Override
	public PostDTO getPost(Integer post_id) {
		  Post post= postRepo.findById(post_id).orElseThrow(()->new ResourceNotFoundException("post", "id", post_id));
		  return modelMapper.map(post, PostDTO.class);
		  }

	@Override
	public List<PostDTO>getallPosts() 
	{
	
	   
//		Pageable p=  (Pageable) ;
	  
//	      Page<Post> pagePost= postRepo.findAll();     
		List<Post> allPosts=                   postRepo.findAll();
//	      List<Post> allPosts=pagePost.getContent();     
		  List<PostDTO> tempEs=  allPosts.stream().map((curr)->modelMapper.map(curr, PostDTO.class)).collect(Collectors.toList());
	      
//	       PostRespone postRespone=new PostRespone();
//	       postRespone.setContent(tempEs);
//	       postRespone.setPageNumber(pagePost.getNumber());	       
//           postRespone.setTotalElements(pagePost.getNumberOfElements());
//           postRespone.setPageSize(pagePost.getSize());
//           postRespone.setTotalPages(pagePost.getTotalPages());
//           postRespone.setLastPage(pagePost.isLast());
           return tempEs;           }
				  
	public List<PostDTO> getPostsByCategorty(Integer cat_id) {
		// TODO Auto-generated method stub
		Category category= categoryRepo.findById(cat_id).orElseThrow(()->new ResourceNotFoundException("category","Id",cat_id));
		 List<Post>ans= postRepo.findByCategory(category);
		 return ans.stream()
				    .map(curr -> modelMapper.map(curr, PostDTO.class))
				    .collect(Collectors.toList());
	}

	@Override
	public List<PostDTO> getPostsByUsers(Integer user_id) {
		// TODO Auto-generated method stub
		User user =userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User","id",user_id));
		List<Post>ans=postRepo.findByUser(user);			
				
				return ans.stream()
			    .map(curr -> modelMapper.map(curr, PostDTO.class))
			    .collect(Collectors.toList());
		
//		return null;
	}

	@Override
	public List<PostDTO>searchPost(String keyboard) {
		// TODO Auto-generated method stub
	    List<Post>temp=postRepo.findByTitleContaining(keyboard);
	 return     temp.stream().map((post)->modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());           
//return null;
	}




	@Override
	public PostDTO udatePost(PostDTO postDTO, Integer post_id) {
		Post pos=postRepo.findById(post_id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", post_id));
		
		pos.setTitle(postDTO.getTitle());
		pos.setContent(postDTO.getContent());
		pos.setAddedDate(new Date());
		
		postRepo.save(pos);
		return modelMapper.map(pos, PostDTO.class); 
	}

}
