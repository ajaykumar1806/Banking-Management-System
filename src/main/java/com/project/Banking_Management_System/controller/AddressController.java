package com.project.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Banking_Management_System.dto.Address;
import com.project.Banking_Management_System.service.AddressService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;
@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/saveAddress")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address)
	{
		return addressService.saveAddress(address);
	}
	
	@GetMapping("/fetchAddressById")
	public ResponseStructure<Address> fetchAddressById(@RequestParam int addressId)
	{
		return addressService.fetchAddressById(addressId);
	}
	
	@PutMapping("/updateAddress")
	public ResponseStructure<Address> updateAddress(@RequestBody Address address,@RequestParam int oldAddressId)
	{
		address.setAddressId(oldAddressId);
		return addressService.saveAddress(address);
	}
	
	@DeleteMapping("/deleteAddress")
	public ResponseStructure<Address> deleteAddress(@RequestParam int addressId) {
		return addressService.deleteAddress(addressId);
	}
	
	@GetMapping("/fetchAllAddress")
	public ResponseStructureList<Address> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}

}
