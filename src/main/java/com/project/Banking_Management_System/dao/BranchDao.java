package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Address;
import com.project.Banking_Management_System.dto.Branch;
import com.project.Banking_Management_System.dto.Customer;
import com.project.Banking_Management_System.dto.Employee;
import com.project.Banking_Management_System.dto.Manager;
import com.project.Banking_Management_System.repo.BranchRepo;
@Repository
public class BranchDao {
	
	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	public Branch saveBranch(Branch branch)
	{
		return branchRepo.save(branch);
	}
	
	public Branch fetchBranchById(int branchId)
	{
		Optional<Branch> branch=branchRepo.findById(branchId);
		return (branch.isPresent()) ? branch.get() : null;
	}
	
	public Branch updateBranch(Branch branch,int oldBranchId)
	{
		branch.setBranchId(oldBranchId);
		return branchRepo.save(branch);
	}
	
	public Branch deleteBranch(int branchId) {
		Branch branch=fetchBranchById(branchId);
		branchRepo.deleteById(branchId);
		return branch;
	}
	
	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();
	}
	
	public Branch addExistingManagerToExistingBranch(int managerId,int branchId) {
		Manager manager=managerDao.fetchManagerById(managerId);
		Branch branch=fetchBranchById(branchId);
		branch.setManager(manager);
		return saveBranch(branch);
	}
	
	public Branch addExistingAddressToExistingBranch(int addressId,int branchId) {
		Address address=addressDao.fetchAddressById(addressId);
		Branch branch=fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addExistingEmployeeToExistingBranch(int branchId,int employeeId) {
		Branch branch=fetchBranchById(branchId);
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		List<Employee> list=branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee employee) {
		Branch branch=fetchBranchById(branchId);
		List<Employee> list=branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	
	public Branch addExistingCustomerToExistingBranch(int branchId,int customerId) {
		Branch branch=fetchBranchById(branchId);
		Customer customer=customerDao.fetchCustomerById(customerId);
		List<Customer> list=branch.getCustomer();
		list.add(customer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}
	
	public Branch addNewCustomerToExistingBranch(int branchId,Customer customer) {
		Branch branch=fetchBranchById(branchId);
		List<Customer> list=branch.getCustomer();
		list.add(customer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}
	
	
	
	
	
	
	
	
	

}
