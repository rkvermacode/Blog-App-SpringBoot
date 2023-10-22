package com.rkvermacode.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

//	String resourceName;
//	String fieldName;
//	Long fieldValue;
//	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
//		super(String.format("%s not found with %s : %l",resourceName,fieldName,fieldValue));
//		this.resourceName = resourceName;
//		this.fieldName = fieldName;
//		this.fieldValue = fieldValue;
//	}
	
	
	
	
	
	
}
