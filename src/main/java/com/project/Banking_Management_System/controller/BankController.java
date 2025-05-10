package com.project.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Banking_Management_System.dto.Bank;
import com.project.Banking_Management_System.dto.Branch;
import com.project.Banking_Management_System.service.BankService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;
@RestController
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@PostMapping("/saveBank")
	public ResponseStructure<Bank> saveBank(@RequestBody Bank bank)
	{
		return bankService.saveBank(bank);
	}
	
	@GetMapping("/fetchBankById")
	public ResponseStructure<Bank> fetchBankById(@RequestParam int bankId)
	{
		return bankService.fetchBankById(bankId);
	}
	
	@PutMapping("/updateBank")
	public ResponseStructure<Bank> updateBank(@RequestBody Bank bank,@RequestParam int oldBankId)
	{
		bank.setBankId(oldBankId);
		return bankService.saveBank(bank);
	}
	
	@DeleteMapping("/deleteBank")
	public ResponseStructure<Bank> deleteBank(@RequestParam int bankId) {
		return bankService.deleteBank(bankId);
	}
	
	@GetMapping("/fetchAllBank")
	public ResponseStructureList<Bank> fetchAllBank() {
		return bankService.fetchAllBank();
	}
	
	@PutMapping("/addExistingBranchToExistingBank")
	public ResponseStructure<Bank> addExistingBranchToExistingBank(@RequestParam int bankId,@RequestParam int branchId) {
		return bankService.addExistingBranchToExistingBank(bankId, branchId);
	}
	
	@PutMapping("/addNewBranchToExistingBank")
	public ResponseStructure<Bank> addNewBranchToExistingBank(@RequestParam int bankId,@RequestBody Branch branch) {
		return bankService.addNewBranchToExistingBank(bankId, branch);
	}

}
