package com.self.blog.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self.blog.exceptions.ResourceNotFoundException;
import com.self.blog.payloads.ApiResponse;
import com.self.blog.payloads.UserDto;
import com.self.blog.services.UserService;
import com.self.blog.services.impl.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController 
{
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private UserServiceImpl userServiceImpl; 
	
	
	@GetMapping("/name")
	public String  getUser(Principal principal)	{
	      	  return principal.getName();	}
	
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser1(@Valid @RequestBody UserDto userDto)
	{ 
//		if(bindingResult.hasErrors())
//			  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
			UserDto tempDto=userService.createUser(userDto);
		 return  new ResponseEntity<>(tempDto,HttpStatus.CREATED);}
	
	
	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userid)	 	
	{
//		if(bindingResult.hasErrors())
//			  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		 UserDto 	userDto2=userService.updateUser(userDto, userid);
		 userDto2.setId(userid);
		 return new ResponseEntity<>(userDto2,HttpStatus.OK);
		
	}
	
	 @DeleteMapping("/{userId}")
	    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable Integer userId) {
	        // Implement deletion logic using userId
		 
		    
	        userService.deleteUser(userId);
//	        
//                  if(ans==true)  	        
	        return  new ResponseEntity<>( new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
//                  else 
//                	  throw new ResourceNotFoundException("user","id",userId);		
	    }
	@GetMapping("/")
	public  ResponseEntity<List<UserDto>>  getAllUsers()
	{ 
		List<UserDto>temp= userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(temp,HttpStatus.OK);
		
	}
	
	
	   @GetMapping("/{userId}")
	    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
	        UserDto userDto = userService.getUserById(userId);
	        return new ResponseEntity<>(userDto, HttpStatus.OK);
	    }
	
	
	 
	 
	
	
	
	
}