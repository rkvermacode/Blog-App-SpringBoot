package com.rkvermacode.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rkvermacode.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
