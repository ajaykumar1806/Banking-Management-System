package com.project.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Banking_Management_System.dto.Loan;
import com.project.Banking_Management_System.service.LoanService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;
@RestController
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@PostMapping("/saveLoan")
	public ResponseStructure<Loan> saveLoan(@RequestBody Loan loan)
	{
		return loanService.saveLoan(loan);
	}
	
	@GetMapping("/fetchLoanById")
	public ResponseStructure<Loan> fetchLoanById(@RequestParam int loanId)
	{
		return loanService.fetchLoanById(loanId);
	}
	
	@PutMapping("/updateLoan")
	public ResponseStructure<Loan> updateLoan(@RequestBody Loan loan,@RequestParam int oldLoanId)
	{
		loan.setLoanId(oldLoanId);
		return loanService.saveLoan(loan);
	}
	
	@DeleteMapping("/deleteLoan")
	public ResponseStructure<Loan> deleteLoan(@RequestParam int loanId) {
		return loanService.deleteLoan(loanId);
	}
	
	@GetMapping("/fetchAllLoan")
	public ResponseStructureList<Loan> fetchAllLoan() {
		return loanService.fetchAllLoan();
	}

}
