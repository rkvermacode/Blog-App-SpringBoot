package com.rkvermacode.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkvermacode.blog.entity.Category;
import com.rkvermacode.blog.exception.ResourceNotFoundException;
import com.rkvermacode.blog.payload.CategoryDto;
import com.rkvermacode.blog.repository.CategoryRepository;
import com.rkvermacode.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category = modelMapper.map(categoryDto, Category.class);
		Category savedCategory = categoryRepository.save(category);
		
		return modelMapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
		
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("category not found with categoryId: "+categoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescribtion(categoryDto.getCategoryDescribtion());
		
		Category updatedCategory = categoryRepository.save(category);
		
		return modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("category not found with categoryId: "+categoryId));
		categoryRepository.delete(category);
	}

	@Override
	public CategoryDto getCategoryById(Long categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("category not found with categoryId: "+categoryId));
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllcategories() {
		List<Category> categories = categoryRepository.findAll();
		
		List<CategoryDto> categoryDtos = categories.stream().map((category)->modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
		
		return categoryDtos;
	}

}
