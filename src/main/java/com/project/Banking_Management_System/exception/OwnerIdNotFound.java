package com.project.Banking_Management_System.exception;

public class OwnerIdNotFound extends RuntimeException{
	
	private String Message="Owner Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}
	

}
