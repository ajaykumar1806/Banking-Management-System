package com.project.Banking_Management_System.exception;

public class EmployeeIdNotFound extends RuntimeException{

	
	private String Message="Employee Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}
}
