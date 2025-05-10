package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Account;
import com.project.Banking_Management_System.repo.AccountRepo;
@Repository
public class AccountDao {
	
	@Autowired
	AccountRepo accountRepo;
	
	public Account saveAccount(Account account)
	{
		return accountRepo.save(account);
	}
	
	public Account fetchAccountById(int accountId)
	{
		Optional<Account> account=accountRepo.findById(accountId);
		return (account.isPresent()) ? account.get() : null;
	}
	
	public Account updateAccount(Account account,int oldAccountId)
	{
		account.setAccountId(oldAccountId);
		return accountRepo.save(account);
	}
	
	public Account deleteAccount(int accountId) {
		Account account=fetchAccountById(accountId);
		accountRepo.deleteById(accountId);
		return account;
	}
	
	public List<Account> fetchAllAccount() {
		return accountRepo.findAll();
	}

}
