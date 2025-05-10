package com.project.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Banking_Management_System.dto.Employee;
import com.project.Banking_Management_System.service.EmployeeService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/fetchEmployeeById")
	public ResponseStructure<Employee> fetchEmployeeById(@RequestParam int employeeId)
	{
		return employeeService.fetchEmployeeById(employeeId);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseStructure<Employee> updateEmployee(@RequestBody Employee employee,@RequestParam int oldEmployeeId)
	{
		employee.setEmployeeId(oldEmployeeId);
		return employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee")
	public ResponseStructure<Employee> deleteEmployee(@RequestParam int employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
	
	@GetMapping("/fetchAllEmployee")
	public ResponseStructureList<Employee> fetchAllEmployee() {
		return employeeService.fetchAllEmployee();
	}

}
