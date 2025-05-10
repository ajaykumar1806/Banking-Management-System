package com.project.Banking_Management_System.exception;

public class AccountIdNotFound extends RuntimeException {
	
	private String Message="Account Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}

}
