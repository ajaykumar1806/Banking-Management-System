package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.EmployeeDao;
import com.project.Banking_Management_System.dto.Employee;
import com.project.Banking_Management_System.exception.EmployeeIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	ResponseStructure<Employee> responseStructure;
	
	@Autowired
	ResponseStructureList<Employee> responseStructureList;
	
	public ResponseStructure<Employee> saveEmployee(Employee employee)
	{
		responseStructure.setMessage("Successfully Inserted Employee Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return responseStructure;
	}
	
	public ResponseStructure<Employee> fetchEmployeeById(int employeeId)
	{
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		if(employee!=null) {
			responseStructure.setMessage("Successfully Fetched Employee From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(employee);
			return responseStructure;
		}
		else throw new EmployeeIdNotFound();
	}
	
	public ResponseStructure<Employee> updateEmployee(Employee employee,int oldEmployeeId)
	{
		Employee oldEmployee=employeeDao.fetchEmployeeById(oldEmployeeId);
		if(oldEmployee!=null) {
			responseStructure.setMessage("Successfully Updated Employee Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			employee.setEmployeeId(oldEmployeeId);
			responseStructure.setData(employeeDao.updateEmployee(employee, oldEmployeeId));
			return responseStructure;
		}
		else throw new EmployeeIdNotFound();
	}
	
	public ResponseStructure<Employee> deleteEmployee(int employeeId) {
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		if(employee!=null) {
			responseStructure.setMessage("Successfully Deleted Employee From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(employeeDao.deleteEmployee(employeeId));
			return responseStructure;
		}
		else throw new EmployeeIdNotFound();
	}
	
	public ResponseStructureList<Employee> fetchAllEmployee() {
		List<Employee> employees=employeeDao.fetchAllEmployee();
		if(employees.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Employees From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(employees);
			return responseStructureList;
		}
		else throw new EmployeeIdNotFound();
	}

}
