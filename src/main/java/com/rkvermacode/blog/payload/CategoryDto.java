package com.rkvermacode.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Long categoryId;
	
	@NotEmpty
	@Size(min = 4, message = "category title must be minimum of 4 characters")
	private String categoryTitle;
	
	@NotEmpty(message = "category description cannot empty")
	private String categoryDescribtion;
}
