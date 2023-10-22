package com.rkvermacode.blog.service;

import java.util.List;

import com.rkvermacode.blog.payload.PostDto;
import com.rkvermacode.blog.payload.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto, Long userId, Long categoryId);
	
	PostDto updatePost(PostDto postDto, Long postId);
	
	void deletePost(Long postId);
	
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	PostDto getPostById(Long postId);
	
	//get All posts by category
	List<PostDto> getPostsByCategory(Long categoryId);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Long userId);
	
	List<PostDto> searchPosts(String keyword);
}
