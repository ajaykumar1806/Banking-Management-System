package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Owner;
import com.project.Banking_Management_System.dto.Bank;
import com.project.Banking_Management_System.repo.OwnerRepo;
@Repository
public class OwnerDao {
	
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	BankDao bankDao;
	
	public Owner saveOwner(Owner owner)
	{
		return ownerRepo.save(owner);
	}
	
	public Owner fetchOwnerById(int ownerId)
	{
		Optional<Owner> owner=ownerRepo.findById(ownerId);
		return (owner.isPresent()) ? owner.get() : null;
	}
	
	public Owner updateOwner(Owner owner,int oldOwnerId)
	{
		owner.setOwnerId(oldOwnerId);
		return ownerRepo.save(owner);
	}
	
	public Owner deleteOwner(int ownerId) {
		Owner owner=fetchOwnerById(ownerId);
		ownerRepo.deleteById(ownerId);
		return owner;
	}
	
	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();
	}
	
	public Owner addExistingBankToExistingOwner(int ownerId,int bankId) {
		Owner owner=fetchOwnerById(ownerId);
		Bank bank=bankDao.fetchBankById(bankId);
		owner.setBank(bank);
		return saveOwner(owner);
	}
	

}
