package com.project.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Banking_Management_System.dto.Manager;
import com.project.Banking_Management_System.service.ManagerService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;
@RestController
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/saveManager")
	public ResponseStructure<Manager> saveManager(@RequestBody Manager manager)
	{
		return managerService.saveManager(manager);
	}
	
	@GetMapping("/fetchManagerById")
	public ResponseStructure<Manager> fetchManagerById(@RequestParam int managerId)
	{
		return managerService.fetchManagerById(managerId);
	}
	
	@PutMapping("/updateManager")
	public ResponseStructure<Manager> updateManager(@RequestBody Manager manager,@RequestParam int oldManagerId)
	{
		manager.setManagerId(oldManagerId);
		return managerService.saveManager(manager);
	}
	
	@DeleteMapping("/deleteManager")
	public ResponseStructure<Manager> deleteManager(@RequestParam int managerId) {
		return managerService.deleteManager(managerId);
	}
	
	@GetMapping("/fetchAllManager")
	public ResponseStructureList<Manager> fetchAllManager() {
		return managerService.fetchAllManager();
	}

}
