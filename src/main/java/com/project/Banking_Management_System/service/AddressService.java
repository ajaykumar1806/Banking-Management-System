package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.BankDao;
import com.project.Banking_Management_System.dao.AddressDao;
import com.project.Banking_Management_System.dto.Address;
import com.project.Banking_Management_System.exception.AddressIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class AddressService {
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	BankDao bankDao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	
	@Autowired
	ResponseStructureList<Address> responseStructureList;
	
	public ResponseStructure<Address> saveAddress(Address address)
	{
		responseStructure.setMessage("Successfully Inserted Address Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return responseStructure;
	}
	
	public ResponseStructure<Address> fetchAddressById(int addressId)
	{
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null) {
			responseStructure.setMessage("Successfully Fetched Address From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return responseStructure;
		}
		else throw new AddressIdNotFound();
	}
	
	public ResponseStructure<Address> updateAddress(Address address,int oldAddressId)
	{
		Address oldAddress=addressDao.fetchAddressById(oldAddressId);
		if(oldAddress!=null) {
			responseStructure.setMessage("Successfully Updated Address Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			address.setAddressId(oldAddressId);
			responseStructure.setData(addressDao.updateAddress(address, oldAddressId));
			return responseStructure;
		}
		else throw new AddressIdNotFound();
	}
	
	public ResponseStructure<Address> deleteAddress(int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null) {
			responseStructure.setMessage("Successfully Deleted Address From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(addressDao.deleteAddress(addressId));
			return responseStructure;
		}
		else throw new AddressIdNotFound();
	}
	
	public ResponseStructureList<Address> fetchAllAddress() {
		List<Address> addresss=addressDao.fetchAllAddress();
		if(addresss.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Addresss From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(addresss);
			return responseStructureList;
		}
		else throw new AddressIdNotFound();
	}

}
