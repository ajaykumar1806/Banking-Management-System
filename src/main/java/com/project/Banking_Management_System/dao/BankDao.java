package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Bank;
import com.project.Banking_Management_System.dto.Branch;
import com.project.Banking_Management_System.repo.BankRepo;
@Repository
public class BankDao {
	
	@Autowired
	BankRepo bankRepo;
	
	@Autowired
	BranchDao branchDao;
	
	public Bank saveBank(Bank bank)
	{
		return bankRepo.save(bank);
	}
	
	public Bank fetchBankById(int bankId)
	{
		Optional<Bank> bank=bankRepo.findById(bankId);
		return (bank.isPresent()) ? bank.get() : null;
	}
	
	public Bank updateBank(Bank bank,int oldBankId)
	{
		bank.setBankId(oldBankId);
		return bankRepo.save(bank);
	}
	
	public Bank deleteBank(int bankId) {
		Bank bank=fetchBankById(bankId);
		bankRepo.deleteById(bankId);
		return bank;
	}
	
	public List<Bank> fetchAllBank() {
		return bankRepo.findAll();
	}
	
	public Bank addExistingBranchToExistingBank(int bankId,int branchId) {
		Bank bank=fetchBankById(bankId);
		Branch branch=branchDao.fetchBranchById(branchId);
		List<Branch> list=bank.getBranch();
		list.add(branch);
		bank.setBranch(list);
		return saveBank(bank);
	}
	
	public Bank addNewBranchToExistingBank(int bankId,Branch branch) {
		Bank bank=fetchBankById(bankId);
		List<Branch> list=bank.getBranch();
		list.add(branch);
		bank.setBranch(list);
		return saveBank(bank);
	}
	
	
	

}
