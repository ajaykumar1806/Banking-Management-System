package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.AccountDao;
import com.project.Banking_Management_System.dao.BankDao;
import com.project.Banking_Management_System.dto.Account;
import com.project.Banking_Management_System.exception.AccountIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class AccountService {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	BankDao bankDao;
	
	@Autowired
	ResponseStructure<Account> responseStructure;
	
	@Autowired
	ResponseStructureList<Account> responseStructureList;
	
	public ResponseStructure<Account> saveAccount(Account account)
	{
		responseStructure.setMessage("Successfully Inserted Account Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(accountDao.saveAccount(account));
		return responseStructure;
	}
	
	public ResponseStructure<Account> fetchAccountById(int accountId)
	{
		Account account=accountDao.fetchAccountById(accountId);
		if(account!=null) {
			responseStructure.setMessage("Successfully Fetched Account From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(account);
			return responseStructure;
		}
		else throw new AccountIdNotFound();
	}
	
	public ResponseStructure<Account> updateAccount(Account account,int oldAccountId)
	{
		Account oldAccount=accountDao.fetchAccountById(oldAccountId);
		if(oldAccount!=null) {
			responseStructure.setMessage("Successfully Updated Account Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			account.setAccountId(oldAccountId);
			responseStructure.setData(accountDao.updateAccount(account, oldAccountId));
			return responseStructure;
		}
		else throw new AccountIdNotFound();
	}
	
	public ResponseStructure<Account> deleteAccount(int accountId) {
		Account account=accountDao.fetchAccountById(accountId);
		if(account!=null) {
			responseStructure.setMessage("Successfully Deleted Account From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(accountDao.deleteAccount(accountId));
			return responseStructure;
		}
		else throw new AccountIdNotFound();
	}
	
	public ResponseStructureList<Account> fetchAllAccount() {
		List<Account> accounts=accountDao.fetchAllAccount();
		if(accounts.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Accounts From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(accounts);
			return responseStructureList;
		}
		else throw new AccountIdNotFound();
	}
	
}