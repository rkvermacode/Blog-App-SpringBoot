package com.rkvermacode.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rkvermacode.blog.entity.Category;
import com.rkvermacode.blog.entity.Post;
import com.rkvermacode.blog.entity.User;

public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	@Query("select p from Post p where p.title like :key")
	List<Post> searchByTitle(@Param("key") String title);
//	List<Post> findByTitleContaining(String title);
}
