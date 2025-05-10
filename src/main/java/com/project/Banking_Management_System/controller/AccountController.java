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
import com.project.Banking_Management_System.service.AccountService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/saveAccount")
	public ResponseStructure<Account> saveAccount(@RequestBody Account account)
	{
		return accountService.saveAccount(account);
	}
	
	@GetMapping("/fetchAccountById")
	public ResponseStructure<Account> fetchAccountById(@RequestParam int accountId)
	{
		return accountService.fetchAccountById(accountId);
	}
	
	@PutMapping("/updateAccount")
	public ResponseStructure<Account> updateAccount(@RequestBody Account account,@RequestParam int oldAccountId)
	{
		account.setAccountId(oldAccountId);
		return accountService.saveAccount(account);
	}
	
	@DeleteMapping("/deleteAccount")
	public ResponseStructure<Account> deleteAccount(@RequestParam int accountId) {
		return accountService.deleteAccount(accountId);
	}
	
	@GetMapping("/fetchAllAccount")
	public ResponseStructureList<Account> fetchAllAccount() {
		return accountService.fetchAllAccount();
	}

}
