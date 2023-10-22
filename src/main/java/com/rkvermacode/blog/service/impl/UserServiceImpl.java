package com.rkvermacode.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkvermacode.blog.entity.User;
import com.rkvermacode.blog.exception.ResourceNotFoundException;
import com.rkvermacode.blog.payload.UserDto;
import com.rkvermacode.blog.repository.UserRepository;
import com.rkvermacode.blog.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		//convert userDto to user
		User user = modelMapper.map(userDto, User.class);
		
		User savedUser = this.userRepository.save(user);
		
		//return user to userDto
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with userId: "+userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepository.save(user);
		
		return modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with userId: "+userId));
		
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepository.findAll();
		
		List<UserDto> userDtos = users.stream().map((user)->this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with userId: "+userId));
		
		this.userRepository.delete(user);
	}
	
	
		
		

}
