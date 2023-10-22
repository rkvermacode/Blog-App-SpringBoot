package com.rkvermacode.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkvermacode.blog.payload.ApiResponse;
import com.rkvermacode.blog.payload.UserDto;
import com.rkvermacode.blog.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blog/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	 
	@PutMapping("{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Long userId){
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Long userId){
		this.userService.deleteUser(userId);
		return ResponseEntity.ok(new ApiResponse("user deleted successfully",true));
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUser());
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable("userId") Long userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}
