package com.project.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Banking_Management_System.dto.Branch;
import com.project.Banking_Management_System.dto.Customer;
import com.project.Banking_Management_System.dto.Employee;
import com.project.Banking_Management_System.service.BranchService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;
@RestController
public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch)
	{
		return branchService.saveBranch(branch);
	}
	
	@GetMapping("/fetchBranchById")
	public ResponseStructure<Branch> fetchBranchById(@RequestParam int branchId)
	{
		return branchService.fetchBranchById(branchId);
	}
	
	@PutMapping("/updateBranch")
	public ResponseStructure<Branch> updateBranch(@RequestBody Branch branch,@RequestParam int oldBranchId)
	{
		branch.setBranchId(oldBranchId);
		return branchService.saveBranch(branch);
	}
	
	@DeleteMapping("/deleteBranch")
	public ResponseStructure<Branch> deleteBranch(@RequestParam int branchId) {
		return branchService.deleteBranch(branchId);
	}
	
	@GetMapping("/fetchAllBranch")
	public ResponseStructureList<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}
	
	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseStructure<Branch> addExistingManagerToExistingBranch(@RequestParam int managerId,@RequestParam int branchId) {
		return branchService.addExistingManagerToExistingBranch(managerId, branchId);
	}
	
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(@RequestParam int addressId,@RequestParam int branchId) {
		return branchService.addExistingAddressToExistingBranch(addressId, branchId);
	}
	
	@PutMapping("/addExistingEmployeeToExistingBranch")
	public ResponseStructure<Branch> addExistingEmployeeToExistingBranch(@RequestParam int branchId,@RequestParam int employeeId) {
		return branchService.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}
	
	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseStructure<Branch> addNewEmployeeToExistingBranch(@RequestParam int branchId,@RequestBody Employee employee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, employee);
	}
	
	@PutMapping("/addExistingCustomerToExistingBranch")
	public ResponseStructure<Branch> addExistingCustomerToExistingBranch(@RequestParam int branchId,@RequestParam int customerId) {
		return branchService.addExistingAddressToExistingBranch(branchId, customerId);
	}
	
	@PutMapping("/addNewCustomerToExistingBranch")
	public ResponseStructure<Branch> addNewCustomerToExistingBranch(@RequestParam int branchId,@RequestBody Customer customer) {
		return branchService.addNewCustomerToExistingBranch(branchId, customer);
	}

}
