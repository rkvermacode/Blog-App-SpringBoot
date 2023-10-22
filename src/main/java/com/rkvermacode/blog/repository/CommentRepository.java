package com.rkvermacode.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rkvermacode.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
