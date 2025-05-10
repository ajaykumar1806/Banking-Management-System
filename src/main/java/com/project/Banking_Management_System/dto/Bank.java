package com.project.Banking_Management_System.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	private String bankName;
	private long bankPhone;
	private String bankGst;
	private String bankIfsc;
	private String bankEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branch;
	
	
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public long getBankPhone() {
		return bankPhone;
	}
	public void setBankPhone(long bankPhone) {
		this.bankPhone = bankPhone;
	}
	public String getBankGst() {
		return bankGst;
	}
	public void setBankGst(String bankGst) {
		this.bankGst = bankGst;
	}
	public String getBankIfsc() {
		return bankIfsc;
	}
	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}
	public String getBankEmail() {
		return bankEmail;
	}
	public void setBankEmail(String bankEmail) {
		this.bankEmail = bankEmail;
	}
	
	
	

}
