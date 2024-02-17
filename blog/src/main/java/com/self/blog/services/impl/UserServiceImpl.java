package com.self.blog.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.blog.exceptions.*;
import com.self.blog.entity.User;
import com.self.blog.payloads.UserDto;
import com.self.blog.repository.UserRepo;
import com.self.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo   userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
			User user =dtotouser(userDto);
			User ansUser= userRepo.save(user);		
			return usertoDto(ansUser);	
		}



	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		Optional<User> optionalUser = userRepo.findById(userId); // Your Optional<User> object
		User user = optionalUser.orElseThrow(() -> new ResourceNotFoundException("User","id",userId)); // Throws an exception if Optional is empty

		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		
		
		User ansUser= userRepo.save(user);		
		
		return usertoDto(ansUser);	
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User temp=(userRepo.findById(userId)).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
		if(temp==null)
		{
			throw new ResourceNotFoundException("User","id",userId); 	
		}
		else 
		{
			return usertoDto(temp);					
		}
		
//		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<User> user=userRepo.findAll();
		return user.stream().map(curr->usertoDto(curr)).collect(Collectors.toList());
		
//		return null;
	}

	@Override
	public void  deleteUser(Integer userId) 
	{
		
		User  remp=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id",userId));
//		{
//			 throw new ResourceNotFoundException("User","id", userId);	}
//		else 
         userRepo.delete(remp); 
//		return true;}
//		return false;
		
	}
	
	private User dtotouser(UserDto userDto)
	{
		User user=this.modelMapper.map(userDto,User.class);
//		User user=new User();
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setPassword(userDto.getPassword());
		
		
		return user;
	}
	private UserDto usertoDto(User user)
	{
//		
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
//		userDto.setAbout(user.getAbout());
//		userDto.setEmail(user.getEmail());
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setPassword(user.getPassword());
		
		
		return userDto;
	}
}
