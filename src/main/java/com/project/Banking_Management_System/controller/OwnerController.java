package com.project.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Banking_Management_System.dto.Owner;
import com.project.Banking_Management_System.service.BankService;
import com.project.Banking_Management_System.service.OwnerService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;
@RestController
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
	
	@Autowired
	BankService bankService;
	
	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner)
	{
		return ownerService.saveOwner(owner);
	}
	
	@GetMapping("/fetchOwnerById")
	public ResponseStructure<Owner> fetchOwnerById(@RequestParam int ownerId)
	{
		return ownerService.fetchOwnerById(ownerId);
	}
	
	@PutMapping("/updateOwner")
	public ResponseStructure<Owner> updateOwner(@RequestBody Owner owner,@RequestParam int oldOwnerId)
	{
		owner.setOwnerId(oldOwnerId);
		return ownerService.saveOwner(owner);
	}
	
	@DeleteMapping("/deleteOwner")
	public ResponseStructure<Owner> deleteOwner(@RequestParam int ownerId) {
		return ownerService.deleteOwner(ownerId);
	}
	
	@GetMapping("/fetchAllOwner")
	public ResponseStructureList<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}
	
	@PutMapping("/addExistingBankToExistingOwner")
	public ResponseStructure<Owner> addExistingBankToExistingOwner(@RequestParam int ownerId,@RequestParam int bankId) {
		return ownerService.addExistingBankToExistingOwner(ownerId, bankId);
	}

}
