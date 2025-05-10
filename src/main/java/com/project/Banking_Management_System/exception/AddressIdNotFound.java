package com.project.Banking_Management_System.exception;

public class AddressIdNotFound extends RuntimeException{

	
	private String Message="Address Id Not Found In DataBase";

	public String getMessage() {
		return Message;
	}
}
