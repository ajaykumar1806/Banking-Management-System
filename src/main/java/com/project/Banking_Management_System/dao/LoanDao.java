package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Loan;
import com.project.Banking_Management_System.repo.LoanRepo;
@Repository
public class LoanDao {
	
	@Autowired
	LoanRepo loanRepo;
	
	public Loan saveLoan(Loan loan)
	{
		return loanRepo.save(loan);
	}
	
	public Loan fetchLoanById(int loanId)
	{
		Optional<Loan> loan=loanRepo.findById(loanId);
		return (loan.isPresent()) ? loan.get() : null;
	}
	
	public Loan updateLoan(Loan loan,int oldLoanId)
	{
		loan.setLoanId(oldLoanId);
		return loanRepo.save(loan);
	}
	
	public Loan deleteLoan(int loanId) {
		Loan loan=fetchLoanById(loanId);
		loanRepo.deleteById(loanId);
		return loan;
	}
	
	public List<Loan> fetchAllLoan() {
		return loanRepo.findAll();
	}
	

}
