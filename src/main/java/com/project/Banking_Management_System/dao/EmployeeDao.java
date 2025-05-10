package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Employee;
import com.project.Banking_Management_System.repo.EmployeeRepo;
@Repository
public class EmployeeDao {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	
	public Employee fetchEmployeeById(int employeeId)
	{
		Optional<Employee> employee=employeeRepo.findById(employeeId);
		return (employee.isPresent()) ? employee.get() : null;
	}
	
	public Employee updateEmployee(Employee employee,int oldEmployeeId)
	{
		employee.setEmployeeId(oldEmployeeId);
		return employeeRepo.save(employee);
	}
	
	public Employee deleteEmployee(int employeeId) {
		Employee employee=fetchEmployeeById(employeeId);
		employeeRepo.deleteById(employeeId);
		return employee;
	}
	
	public List<Employee> fetchAllEmployee() {
		return employeeRepo.findAll();
	}
	

}
