package com.project.Banking_Management_System.exception;

public class FdIdNotFound extends RuntimeException{

	
	private String Message="Fd Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}
}
