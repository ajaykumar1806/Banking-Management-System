package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.BranchDao;
import com.project.Banking_Management_System.dao.CustomerDao;
import com.project.Banking_Management_System.dao.EmployeeDao;
import com.project.Banking_Management_System.dto.Branch;
import com.project.Banking_Management_System.dto.Customer;
import com.project.Banking_Management_System.dto.Employee;
import com.project.Banking_Management_System.exception.BranchIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class BranchService {
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ResponseStructure<Branch> responseStructure;
	
	@Autowired
	ResponseStructureList<Branch> responseStructureList;
	
	public ResponseStructure<Branch> saveBranch(Branch branch)
	{
		responseStructure.setMessage("Successfully Inserted Branch Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;
	}
	
	public ResponseStructure<Branch> fetchBranchById(int branchId)
	{
		Branch branch=branchDao.fetchBranchById(branchId);
		if(branch!=null) {
			responseStructure.setMessage("Successfully Fetched Branch From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return responseStructure;
		}
		else throw new BranchIdNotFound();
	}
	
	public ResponseStructure<Branch> updateBranch(Branch branch,int oldBranchId)
	{
		Branch oldBranch=branchDao.fetchBranchById(oldBranchId);
		if(oldBranch!=null) {
			responseStructure.setMessage("Successfully Updated Branch Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			branch.setBranchId(oldBranchId);
			responseStructure.setData(branchDao.updateBranch(branch, oldBranchId));
			return responseStructure;
		}
		else throw new BranchIdNotFound();
	}
	
	public ResponseStructure<Branch> deleteBranch(int branchId) {
		Branch branch=branchDao.fetchBranchById(branchId);
		if(branch!=null) {
			responseStructure.setMessage("Successfully Deleted Branch From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(branchDao.deleteBranch(branchId));
			return responseStructure;
		}
		else throw new BranchIdNotFound();
	}
	
	public ResponseStructureList<Branch> fetchAllBranch() {
		List<Branch> branchs=branchDao.fetchAllBranch();
		if(branchs.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Branchs From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(branchs);
			return responseStructureList;
		}
		else throw new BranchIdNotFound();
	}
	
	public ResponseStructure<Branch> addExistingManagerToExistingBranch(int managerId,int branchId) {
		responseStructure.setMessage("Successfully Linked Existing Manager To Existing Branch");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingManagerToExistingBranch(managerId, branchId));
		return responseStructure;
	}
	
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(int addressId,int branchId) {
		responseStructure.setMessage("Successfully Linked Existing Address To Existing Branch");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));
		return responseStructure;
	}
	
	public ResponseStructure<Branch> addExistingEmployeeToExistingBranch(int branchId,int employeeId) {
		responseStructure.setMessage("Successfully Linked Existing Employee To Existing Branch");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId));
		return responseStructure;
	}
	
	public ResponseStructure<Branch> addNewEmployeeToExistingBranch(int branchId,Employee employee) {
		responseStructure.setMessage("Successfully Linked New Employee To Existing Branch");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(branchId, employee));
		return responseStructure;
	}
	
	public ResponseStructure<Branch> addExistingCustomerToExistingBranch(int branchId,int customerId) {
		responseStructure.setMessage("Successfully Linked Existing Customer To Existing Branch");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingCustomerToExistingBranch(branchId, customerId));
		return responseStructure;
	}
	
	public ResponseStructure<Branch> addNewCustomerToExistingBranch(int branchId,Customer customer) {
		responseStructure.setMessage("Successfully Linked New Customer To Existing Branch");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addNewCustomerToExistingBranch(branchId, customer));
		return responseStructure;
	}

}
