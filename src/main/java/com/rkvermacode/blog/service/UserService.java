package com.rkvermacode.blog.service;

import java.util.List;

import com.rkvermacode.blog.payload.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Long userId);
	
	UserDto getUserById(Long id);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Long id);
}
