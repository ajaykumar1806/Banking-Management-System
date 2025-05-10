package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.BankDao;
import com.project.Banking_Management_System.dao.BranchDao;
import com.project.Banking_Management_System.dto.Bank;
import com.project.Banking_Management_System.dto.Branch;
import com.project.Banking_Management_System.exception.BankIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class BankService {
	
	@Autowired
	BankDao bankDao;
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	ResponseStructure<Bank> responseStructure;
	
	@Autowired
	ResponseStructureList<Bank> responseStructureList;
	
	public ResponseStructure<Bank> saveBank(Bank bank)
	{
		responseStructure.setMessage("Successfully Inserted Bank Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(bankDao.saveBank(bank));
		return responseStructure;
	}
	
	public ResponseStructure<Bank> fetchBankById(int bankId)
	{
		Bank bank=bankDao.fetchBankById(bankId);
		if(bank!=null) {
			responseStructure.setMessage("Successfully Fetched Bank From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(bank);
			return responseStructure;
		}
		else throw new BankIdNotFound();
	}
	
	public ResponseStructure<Bank> updateBank(Bank bank,int oldBankId)
	{
		Bank oldBank=bankDao.fetchBankById(oldBankId);
		if(oldBank!=null) {
			responseStructure.setMessage("Successfully Updated Bank Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			bank.setBankId(oldBankId);
			responseStructure.setData(bankDao.updateBank(bank, oldBankId));
			return responseStructure;
		}
		else throw new BankIdNotFound();
	}
	
	public ResponseStructure<Bank> deleteBank(int bankId) {
		Bank bank=bankDao.fetchBankById(bankId);
		if(bank!=null) {
			responseStructure.setMessage("Successfully Deleted Bank From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(bankDao.deleteBank(bankId));
			return responseStructure;
		}
		else throw new BankIdNotFound();
	}
	
	public ResponseStructureList<Bank> fetchAllBank() {
		List<Bank> banks=bankDao.fetchAllBank();
		if(banks.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Banks From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(banks);
			return responseStructureList;
		}
		else throw new BankIdNotFound();
	}
	
	public ResponseStructure<Bank> addExistingBranchToExistingBank(int bankId,int branchId) {
		responseStructure.setMessage("Successfully Linked Existing Branch To Existing Bank");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addExistingBranchToExistingBank(bankId,branchId));
		return responseStructure;
	}
	
	public ResponseStructure<Bank> addNewBranchToExistingBank(int bankId,Branch branch) {
		responseStructure.setMessage("Successfully Linked New Branch To Existing Bank");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addNewBranchToExistingBank(bankId, branch));
		return responseStructure;
	}

}
