package com.self.blog.services;


import java.util.List;



import com.self.blog.payloads.UserDto;


public interface UserService {
   UserDto createUser(UserDto user);
   
//   UserDto createUser(UserDto user, Integer userId);
   UserDto updateUser(UserDto user, Integer userId);  
   UserDto getUserById(Integer userId);
   List<UserDto>getAllUsers();
   
   void deleteUser(Integer userId);

}
