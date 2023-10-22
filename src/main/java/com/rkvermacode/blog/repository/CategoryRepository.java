package com.rkvermacode.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rkvermacode.blog.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
