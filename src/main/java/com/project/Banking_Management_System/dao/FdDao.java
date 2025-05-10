package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Fd;
import com.project.Banking_Management_System.repo.FdRepo;
@Repository
public class FdDao {
	
	@Autowired
	FdRepo fdRepo;
	
	public Fd saveFd(Fd fd)
	{
		return fdRepo.save(fd);
	}
	
	public Fd fetchFdById(int fdId)
	{
		Optional<Fd> fd=fdRepo.findById(fdId);
		return (fd.isPresent()) ? fd.get() : null;
	}
	
	public Fd updateFd(Fd fd,int oldFdId)
	{
		fd.setFdId(oldFdId);
		return fdRepo.save(fd);
	}
	
	public Fd deleteFd(int fdId) {
		Fd fd=fetchFdById(fdId);
		fdRepo.deleteById(fdId);
		return fd;
	}
	
	public List<Fd> fetchAllFd() {
		return fdRepo.findAll();
	}
	

}
