package com.project.Banking_Management_System.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.Banking_Management_System.util.ResponseStructure;

@RestControllerAdvice
public class AplicationExceptionHandler {
	
	@Autowired
	ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseStructure<String> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound){
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return responseStructure;
	}
	

}
