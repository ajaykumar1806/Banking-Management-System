package com.project.Banking_Management_System.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String customerDob;
	private int customerAge;
	private long customerPhone;
	private String customerEmail;
	private long customerAadharCard;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Account> account;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Loan> loan;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Fd> fd;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Card> card;
	
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	public List<Loan> getLoan() {
		return loan;
	}
	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}
	public List<Fd> getFd() {
		return fd;
	}
	public void setFd(List<Fd> fd) {
		this.fd = fd;
	}
	public List<Card> getCard() {
		return card;
	}
	public void setCard(List<Card> card) {
		this.card = card;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDob(String customerDob) {
		this.customerDob = customerDob;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public long getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public long getCustomerAadharCard() {
		return customerAadharCard;
	}
	public void setCustomerAadharCard(long customerAadharCard) {
		this.customerAadharCard = customerAadharCard;
	}
	
	
}
