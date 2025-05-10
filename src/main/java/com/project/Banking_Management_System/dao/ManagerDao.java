package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Manager;
import com.project.Banking_Management_System.repo.ManagerRepo;
@Repository
public class ManagerDao {
	
	@Autowired
	ManagerRepo managerRepo;
	
	public Manager saveManager(Manager manager)
	{
		return managerRepo.save(manager);
	}
	
	public Manager fetchManagerById(int managerId)
	{
		Optional<Manager> manager=managerRepo.findById(managerId);
		return (manager.isPresent()) ? manager.get() : null;
	}
	
	public Manager updateManager(Manager manager,int oldManagerId)
	{
		manager.setManagerId(oldManagerId);
		return managerRepo.save(manager);
	}
	
	public Manager deleteManager(int managerId) {
		Manager manager=fetchManagerById(managerId);
		managerRepo.deleteById(managerId);
		return manager;
	}
	
	public List<Manager> fetchAllManager() {
		return managerRepo.findAll();
	}
	

}
