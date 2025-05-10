package com.project.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Banking_Management_System.dto.Account;
import com.project.Banking_Management_System.dto.Card;
import com.project.Banking_Management_System.dto.Customer;
import com.project.Banking_Management_System.dto.Fd;
import com.project.Banking_Management_System.dto.Loan;
import com.project.Banking_Management_System.service.CustomerService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseStructure<Customer> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/fetchCustomerById")
	public ResponseStructure<Customer> fetchCustomerById(@RequestParam int customerId) {
		return customerService.fetchCustomerById(customerId);
	}

	@PutMapping("/updateCustomer")
	public ResponseStructure<Customer> updateCustomer(@RequestBody Customer customer, @RequestParam int oldCustomerId) {
		customer.setCustomerId(oldCustomerId);
		return customerService.saveCustomer(customer);
	}

	@DeleteMapping("/deleteCustomer")
	public ResponseStructure<Customer> deleteCustomer(@RequestParam int customerId) {
		return customerService.deleteCustomer(customerId);
	}

	@GetMapping("/fetchAllCustomer")
	public ResponseStructureList<Customer> fetchAllCustomer() {
		return customerService.fetchAllCustomer();
	}

	@PutMapping("/addExistingAccountToExistingCustomer")
	public ResponseStructure<Customer> addExistingAccountToExistingCustomer(@RequestParam int customerId, @RequestParam int accountId) {
		return customerService.addExistingAccountToExistingCustomer(customerId, accountId);
	}

	@PutMapping("/addNewAccountToExistingCustomer")
	public ResponseStructure<Customer> addNewAccountToExistingCustomer(@RequestParam int customerId, @RequestBody Account account) {
		return customerService.addNewAccountToExistingCustomer(customerId, account);
	}

	@PutMapping("/addExistingLoanToExistingCustomer")
	public ResponseStructure<Customer> addExistingLoanToExistingCustomer(@RequestParam int customerId, @RequestParam int loanId) {
		return customerService.addExistingLoanToExistingCustomer(customerId, loanId);
	}

	@PutMapping("/addNewLoanToExistingCustomer")
	public ResponseStructure<Customer> addNewLoanToExistingCustomer(@RequestParam int customerId, @RequestBody Loan loan) {
		return customerService.addNewLoanToExistingCustomer(customerId, loan);
	}

	@PutMapping("/addExistingFdToExistingCustomer")
	public ResponseStructure<Customer> addExistingFdToExistingCustomer(@RequestParam int customerId, @RequestParam int fdId) {
		return customerService.addExistingFdToExistingCustomer(customerId, fdId);
	}

	@PutMapping("/addNewFdToExistingCustomer")
	public ResponseStructure<Customer> addNewFdToExistingCustomer(@RequestParam int customerId, @RequestBody Fd fd) {
		return customerService.addNewFdToExistingCustomer(customerId, fd);
	}

	@PutMapping("/addExistingCardToExistingCustomer")
	public ResponseStructure<Customer> addExistingCardToExistingCustomer(@RequestParam int customerId, @RequestParam int cardId) {
		return customerService.addExistingCardToExistingCustomer(customerId, cardId);
	}

	@PutMapping("/addNewCardToExistingCustomer")
	public ResponseStructure<Customer> addNewCardToExistingCustomer(@RequestParam int customerId, @RequestBody Card card) {
		return customerService.addNewCardToExistingCustomer(customerId, card);
	}

}
