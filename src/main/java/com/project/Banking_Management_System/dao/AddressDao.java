package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Address;
import com.project.Banking_Management_System.repo.AddressRepo;
@Repository
public class AddressDao {
	
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address)
	{
		return addressRepo.save(address);
	}
	
	public Address fetchAddressById(int addressId)
	{
		Optional<Address> address=addressRepo.findById(addressId);
		return (address.isPresent()) ? address.get() : null;
	}
	
	public Address updateAddress(Address address,int oldAddressId)
	{
		address.setAddressId(oldAddressId);
		return addressRepo.save(address);
	}
	
	public Address deleteAddress(int addressId) {
		Address address=fetchAddressById(addressId);
		addressRepo.deleteById(addressId);
		return address;
	}
	
	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
	

}
