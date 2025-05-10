package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Account;
import com.project.Banking_Management_System.dto.Card;
import com.project.Banking_Management_System.dto.Customer;
import com.project.Banking_Management_System.dto.Fd;
import com.project.Banking_Management_System.dto.Loan;
import com.project.Banking_Management_System.repo.CustomerRepo;
@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	FdDao fdDao;
	
	@Autowired
	LoanDao loanDao;
	
	@Autowired
	CardDao cardDao;
	
	public Customer saveCustomer(Customer customer)
	{
		return customerRepo.save(customer);
	}
	
	public Customer fetchCustomerById(int customerId)
	{
		Optional<Customer> customer=customerRepo.findById(customerId);
		return (customer.isPresent()) ? customer.get() : null;
	}
	
	public Customer updateCustomer(Customer customer,int oldCustomerId)
	{
		customer.setCustomerId(oldCustomerId);
		return customerRepo.save(customer);
	}
	
	public Customer deleteCustomer(int customerId) {
		Customer customer=fetchCustomerById(customerId);
		customerRepo.deleteById(customerId);
		return customer;
	}
	
	public List<Customer> fetchAllCustomer() {
		return customerRepo.findAll();
	}
	
	public Customer addExistingAccountToExistingCustomer(int customerId,int accountId) {
		Customer customer=fetchCustomerById(customerId);
		Account account=accountDao.fetchAccountById(accountId);
		List<Account> list=customer.getAccount();
		list.add(account);
		customer.setAccount(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewAccountToExistingCustomer(int customerId,Account account) {
		Customer customer=fetchCustomerById(customerId);
		List<Account> list=customer.getAccount();
		list.add(account);
		customer.setAccount(list);
		return saveCustomer(customer);
	}
	
	public Customer addExistingLoanToExistingCustomer(int customerId,int loanId) {
		Customer customer=fetchCustomerById(customerId);
		Loan loan=loanDao.fetchLoanById(loanId);
		List<Loan> list=customer.getLoan();
		list.add(loan);
		customer.setLoan(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewLoanToExistingCustomer(int customerId,Loan loan) {
		Customer customer=fetchCustomerById(customerId);
		List<Loan> list=customer.getLoan();
		list.add(loan);
		customer.setLoan(list);
		return saveCustomer(customer);
	}
	
	public Customer addExistingCardToExistingCustomer(int customerId,int cardId) {
		Customer customer=fetchCustomerById(customerId);
		Card card=cardDao.fetchCardById(cardId);
		List<Card> list=customer.getCard();
		list.add(card);
		customer.setCard(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewCardToExistingCustomer(int customerId,Card card) {
		Customer customer=fetchCustomerById(customerId);
		List<Card> list=customer.getCard();
		list.add(card);
		customer.setCard(list);
		return saveCustomer(customer);
	}
	
	public Customer addExistingFdToExistingCustomer(int customerId,int fdId) {
		Customer customer=fetchCustomerById(customerId);
		Fd fd=fdDao.fetchFdById(fdId);
		List<Fd> list=customer.getFd();
		list.add(fd);
		customer.setFd(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewFdToExistingCustomer(int customerId,Fd fd) {
		Customer customer=fetchCustomerById(customerId);
		List<Fd> list=customer.getFd();
		list.add(fd);
		customer.setFd(list);
		return saveCustomer(customer);
	}
	
	

}
