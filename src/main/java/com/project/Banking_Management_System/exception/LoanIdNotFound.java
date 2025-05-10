package com.project.Banking_Management_System.exception;

public class LoanIdNotFound extends RuntimeException{
	
	private String Message="Loan Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}

}
