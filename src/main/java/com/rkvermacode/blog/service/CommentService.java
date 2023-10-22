package com.rkvermacode.blog.service;

import com.rkvermacode.blog.payload.CommentDto;

public interface CommentService {

	CommentDto creaComment(CommentDto commentDto, Long postId);
	
	void deleteComment(Long commentId);
}
