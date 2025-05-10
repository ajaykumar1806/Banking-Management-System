package com.project.Banking_Management_System.exception;

public class BankIdNotFound extends RuntimeException{
	
	private String Message="Bank Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}

}
