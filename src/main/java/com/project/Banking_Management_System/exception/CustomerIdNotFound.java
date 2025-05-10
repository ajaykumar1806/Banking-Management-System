package com.project.Banking_Management_System.exception;

public class CustomerIdNotFound extends RuntimeException{
	
	private String Message="Customer Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}

}
