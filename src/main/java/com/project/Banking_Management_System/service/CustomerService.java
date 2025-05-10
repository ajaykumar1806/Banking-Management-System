package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.CustomerDao;
import com.project.Banking_Management_System.dto.Account;
import com.project.Banking_Management_System.dto.Card;
import com.project.Banking_Management_System.dto.Customer;
import com.project.Banking_Management_System.dto.Fd;
import com.project.Banking_Management_System.dto.Loan;
import com.project.Banking_Management_System.exception.CustomerIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ResponseStructure<Customer> responseStructure;
	
	@Autowired
	ResponseStructureList<Customer> responseStructureList;
	
	public ResponseStructure<Customer> saveCustomer(Customer customer)
	{
		responseStructure.setMessage("Successfully Inserted Customer Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> fetchCustomerById(int customerId)
	{
		Customer customer=customerDao.fetchCustomerById(customerId);
		if(customer!=null) {
			responseStructure.setMessage("Successfully Fetched Customer From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(customer);
			return responseStructure;
		}
		else throw new CustomerIdNotFound();
	}
	
	public ResponseStructure<Customer> updateCustomer(Customer customer,int oldCustomerId)
	{
		Customer oldCustomer=customerDao.fetchCustomerById(oldCustomerId);
		if(oldCustomer!=null) {
			responseStructure.setMessage("Successfully Updated Customer Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			customer.setCustomerId(oldCustomerId);
			responseStructure.setData(customerDao.updateCustomer(customer, oldCustomerId));
			return responseStructure;
		}
		else throw new CustomerIdNotFound();
	}
	
	public ResponseStructure<Customer> deleteCustomer(int customerId) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		if(customer!=null) {
			responseStructure.setMessage("Successfully Deleted Customer From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(customerDao.deleteCustomer(customerId));
			return responseStructure;
		}
		else throw new CustomerIdNotFound();
	}
	
	public ResponseStructureList<Customer> fetchAllCustomer() {
		List<Customer> customers=customerDao.fetchAllCustomer();
		if(customers.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Customers From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(customers);
			return responseStructureList;
		}
		else throw new CustomerIdNotFound();
	}
	
	public ResponseStructure<Customer> addExistingAccountToExistingCustomer(int customerId,int accountId) {
		responseStructure.setMessage("Successfully Linked Existing Account To Existing Customer");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingAccountToExistingCustomer(customerId, accountId));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addNewAccountToExistingCustomer(int customerId,Account account) {
		responseStructure.setMessage("Successfully Linked New Account To Existing Customer");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewAccountToExistingCustomer(customerId, account));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addExistingLoanToExistingCustomer(int customerId,int loanId) {
		responseStructure.setMessage("Successfully Linked Existing Loan To Existing Customer");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingLoanToExistingCustomer(customerId, loanId));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addNewLoanToExistingCustomer(int customerId,Loan loan) {
		responseStructure.setMessage("Successfully Linked New Loan To Existing Customer");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewLoanToExistingCustomer(customerId, loan));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addExistingFdToExistingCustomer(int customerId,int fdId) {
		responseStructure.setMessage("Successfully Linked Existing Fd To Existing Customer");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingFdToExistingCustomer(customerId, fdId));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addNewFdToExistingCustomer(int customerId,Fd fd) {
		responseStructure.setMessage("Successfully Linked New Fd To Existing Customer");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewFdToExistingCustomer(customerId, fd));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addExistingCardToExistingCustomer(int customerId,int cardId) {
		responseStructure.setMessage("Successfully Linked Existing Card To Existing Customer");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingCardToExistingCustomer(customerId, cardId));
		return responseStructure;
	}
	
	public ResponseStructure<Customer> addNewCardToExistingCustomer(int customerId,Card card) {
		responseStructure.setMessage("Successfully Linked New Card To Existing Customer");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewCardToExistingCustomer(customerId, card));
		return responseStructure;
	}

}
