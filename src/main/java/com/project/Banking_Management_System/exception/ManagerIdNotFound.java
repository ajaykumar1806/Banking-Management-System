package com.project.Banking_Management_System.exception;

public class ManagerIdNotFound extends RuntimeException{

	
	private String Message="Manager Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}
}
