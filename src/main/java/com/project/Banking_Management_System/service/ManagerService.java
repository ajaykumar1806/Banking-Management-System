package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.ManagerDao;
import com.project.Banking_Management_System.dto.Manager;
import com.project.Banking_Management_System.exception.ManagerIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class ManagerService {
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	ResponseStructure<Manager> responseStructure;
	
	@Autowired
	ResponseStructureList<Manager> responseStructureList;
	
	public ResponseStructure<Manager> saveManager(Manager manager)
	{
		responseStructure.setMessage("Successfully Inserted Manager Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(managerDao.saveManager(manager));
		return responseStructure;
	}
	
	public ResponseStructure<Manager> fetchManagerById(int managerId)
	{
		Manager manager=managerDao.fetchManagerById(managerId);
		if(manager!=null) {
			responseStructure.setMessage("Successfully Fetched Manager From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(manager);
			return responseStructure;
		}
		else throw new ManagerIdNotFound();
	}
	
	public ResponseStructure<Manager> updateManager(Manager manager,int oldManagerId)
	{
		Manager oldManager=managerDao.fetchManagerById(oldManagerId);
		if(oldManager!=null) {
			responseStructure.setMessage("Successfully Updated Manager Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			manager.setManagerId(oldManagerId);
			responseStructure.setData(managerDao.updateManager(manager, oldManagerId));
			return responseStructure;
		}
		else throw new ManagerIdNotFound();
	}
	
	public ResponseStructure<Manager> deleteManager(int managerId) {
		Manager manager=managerDao.fetchManagerById(managerId);
		if(manager!=null) {
			responseStructure.setMessage("Successfully Deleted Manager From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(managerDao.deleteManager(managerId));
			return responseStructure;
		}
		else throw new ManagerIdNotFound();
	}
	
	public ResponseStructureList<Manager> fetchAllManager() {
		List<Manager> managers=managerDao.fetchAllManager();
		if(managers.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Managers From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(managers);
			return responseStructureList;
		}
		else throw new ManagerIdNotFound();
	}

}
