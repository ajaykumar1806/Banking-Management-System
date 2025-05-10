package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.BankDao;
import com.project.Banking_Management_System.dao.OwnerDao;
import com.project.Banking_Management_System.dto.Owner;
import com.project.Banking_Management_System.exception.OwnerIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class OwnerService {
	
	@Autowired
	OwnerDao ownerDao;
	
	@Autowired
	BankDao bankDao;
	
	@Autowired
	ResponseStructure<Owner> responseStructure;
	
	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	
	public ResponseStructure<Owner> saveOwner(Owner owner)
	{
		responseStructure.setMessage("Successfully Inserted Owner Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return responseStructure;
	}
	
	public ResponseStructure<Owner> fetchOwnerById(int ownerId)
	{
		Owner owner=ownerDao.fetchOwnerById(ownerId);
		if(owner!=null) {
			responseStructure.setMessage("Successfully Fetched Owner From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(owner);
			return responseStructure;
		}
		else throw new OwnerIdNotFound();
	}
	
	public ResponseStructure<Owner> updateOwner(Owner owner,int oldOwnerId)
	{
		Owner oldOwner=ownerDao.fetchOwnerById(oldOwnerId);
		if(oldOwner!=null) {
			responseStructure.setMessage("Successfully Updated Owner Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			owner.setOwnerId(oldOwnerId);
			responseStructure.setData(ownerDao.updateOwner(owner, oldOwnerId));
			return responseStructure;
		}
		else throw new OwnerIdNotFound();
	}
	
	public ResponseStructure<Owner> deleteOwner(int ownerId) {
		Owner owner=ownerDao.fetchOwnerById(ownerId);
		if(owner!=null) {
			responseStructure.setMessage("Successfully Deleted Owner From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(ownerDao.deleteOwner(ownerId));
			return responseStructure;
		}
		else throw new OwnerIdNotFound();
	}
	
	public ResponseStructureList<Owner> fetchAllOwner() {
		List<Owner> owners=ownerDao.fetchAllOwner();
		if(owners.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Owners From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(owners);
			return responseStructureList;
		}
		else throw new OwnerIdNotFound();
	}
	
	public ResponseStructure<Owner> addExistingBankToExistingOwner(int ownerId,int bankId) {
		responseStructure.setMessage("Successfully Linked Existing Bank To Existing Owner");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.addExistingBankToExistingOwner(ownerId, bankId));
		return responseStructure;
	}

}
