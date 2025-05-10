package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.LoanDao;
import com.project.Banking_Management_System.dto.Loan;
import com.project.Banking_Management_System.exception.LoanIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class LoanService {
	
	@Autowired
	LoanDao loanDao;
	
	@Autowired
	ResponseStructure<Loan> responseStructure;
	
	@Autowired
	ResponseStructureList<Loan> responseStructureList;
	
	public ResponseStructure<Loan> saveLoan(Loan loan)
	{
		responseStructure.setMessage("Successfully Inserted Loan Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(loanDao.saveLoan(loan));
		return responseStructure;
	}
	
	public ResponseStructure<Loan> fetchLoanById(int loanId)
	{
		Loan loan=loanDao.fetchLoanById(loanId);
		if(loan!=null) {
			responseStructure.setMessage("Successfully Fetched Loan From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(loan);
			return responseStructure;
		}
		else throw new LoanIdNotFound();
	}
	
	public ResponseStructure<Loan> updateLoan(Loan loan,int oldLoanId)
	{
		Loan oldLoan=loanDao.fetchLoanById(oldLoanId);
		if(oldLoan!=null) {
			responseStructure.setMessage("Successfully Updated Loan Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			loan.setLoanId(oldLoanId);
			responseStructure.setData(loanDao.updateLoan(loan, oldLoanId));
			return responseStructure;
		}
		else throw new LoanIdNotFound();
	}
	
	public ResponseStructure<Loan> deleteLoan(int loanId) {
		Loan loan=loanDao.fetchLoanById(loanId);
		if(loan!=null) {
			responseStructure.setMessage("Successfully Deleted Loan From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(loanDao.deleteLoan(loanId));
			return responseStructure;
		}
		else throw new LoanIdNotFound();
	}
	
	public ResponseStructureList<Loan> fetchAllLoan() {
		List<Loan> loans=loanDao.fetchAllLoan();
		if(loans.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Loans From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(loans);
			return responseStructureList;
		}
		else throw new LoanIdNotFound();
	}

}
