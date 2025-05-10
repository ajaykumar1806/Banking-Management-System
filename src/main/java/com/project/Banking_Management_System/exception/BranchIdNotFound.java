package com.project.Banking_Management_System.exception;

public class BranchIdNotFound extends RuntimeException{

	
	private String Message="Branch Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}
}
