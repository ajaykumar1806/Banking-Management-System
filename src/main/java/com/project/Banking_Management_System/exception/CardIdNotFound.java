package com.project.Banking_Management_System.exception;

public class CardIdNotFound extends RuntimeException{
	
	private String Message="Card Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}

}
