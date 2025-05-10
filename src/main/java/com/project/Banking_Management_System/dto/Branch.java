package com.project.Banking_Management_System.dto;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private String branchGst;
	private String branchIfsc;
	private long branchPhone;
	private String branchEmail;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Address address;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Manager manager;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Employee> employee;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Customer> customer;
	
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchGst() {
		return branchGst;
	}
	public void setBranchGst(String branchGst) {
		this.branchGst = branchGst;
	}
	public String getBranchIfsc() {
		return branchIfsc;
	}
	public void setBranchIfsc(String branchIfsc) {
		this.branchIfsc = branchIfsc;
	}
	public long getBranchPhone() {
		return branchPhone;
	}
	public void setBranchPhone(long branchPhone) {
		this.branchPhone = branchPhone;
	}
	public String getBranchEmail() {
		return branchEmail;
	}
	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
	
	
	
	
}