package com.project.Banking_Management_System.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private long accountNumber;
	private String accountType;
	private double accountMinimumBalance;
	private String accountNominee;
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountMinimumBalance() {
		return accountMinimumBalance;
	}
	public void setAccountMinimumBalance(double accountMinimumBalance) {
		this.accountMinimumBalance = accountMinimumBalance;
	}
	public String getAccountNominee() {
		return accountNominee;
	}
	public void setAccountNominee(String accountNominee) {
		this.accountNominee = accountNominee;
	}
	
	
}
