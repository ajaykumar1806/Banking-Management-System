package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.FdDao;
import com.project.Banking_Management_System.dto.Fd;
import com.project.Banking_Management_System.exception.FdIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class FdService {
	
	@Autowired
	FdDao fdDao;
	
	@Autowired
	ResponseStructure<Fd> responseStructure;
	
	@Autowired
	ResponseStructureList<Fd> responseStructureList;
	
	public ResponseStructure<Fd> saveFd(Fd fd)
	{
		responseStructure.setMessage("Successfully Inserted Fd Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(fdDao.saveFd(fd));
		return responseStructure;
	}
	
	public ResponseStructure<Fd> fetchFdById(int fdId)
	{
		Fd fd=fdDao.fetchFdById(fdId);
		if(fd!=null) {
			responseStructure.setMessage("Successfully Fetched Fd From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(fd);
			return responseStructure;
		}
		else throw new FdIdNotFound();
	}
	
	public ResponseStructure<Fd> updateFd(Fd fd,int oldFdId)
	{
		Fd oldFd=fdDao.fetchFdById(oldFdId);
		if(oldFd!=null) {
			responseStructure.setMessage("Successfully Updated Fd Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			fd.setFdId(oldFdId);
			responseStructure.setData(fdDao.updateFd(fd, oldFdId));
			return responseStructure;
		}
		else throw new FdIdNotFound();
	}
	
	public ResponseStructure<Fd> deleteFd(int fdId) {
		Fd fd=fdDao.fetchFdById(fdId);
		if(fd!=null) {
			responseStructure.setMessage("Successfully Deleted Fd From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(fdDao.deleteFd(fdId));
			return responseStructure;
		}
		else throw new FdIdNotFound();
	}
	
	public ResponseStructureList<Fd> fetchAllFd() {
		List<Fd> fds=fdDao.fetchAllFd();
		if(fds.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Fds From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(fds);
			return responseStructureList;
		}
		else throw new FdIdNotFound();
	}

}
