package com.rkvermacode.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkvermacode.blog.entity.Comment;
import com.rkvermacode.blog.entity.Post;
import com.rkvermacode.blog.exception.ResourceNotFoundException;
import com.rkvermacode.blog.payload.CommentDto;
import com.rkvermacode.blog.repository.CommentRepository;
import com.rkvermacode.blog.repository.PostRepository;
import com.rkvermacode.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto creaComment(CommentDto commentDto, Long postId) {
		
		Post post = postRepository.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("post not found with postId: "+postId));
		
		Comment comment = modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		
		Comment savedComment = commentRepository.save(comment);
		
		return modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Long commentId) {
		
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(()->new ResourceNotFoundException("comment not found with commentId: "+commentId));
		
		commentRepository.delete(comment);
		
	}

}
