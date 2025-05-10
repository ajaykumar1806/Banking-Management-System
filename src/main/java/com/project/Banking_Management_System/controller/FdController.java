package com.project.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Banking_Management_System.dto.Fd;
import com.project.Banking_Management_System.service.FdService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;
@RestController
public class FdController {
	
	@Autowired
	FdService fdService;
	
	@PostMapping("/saveFd")
	public ResponseStructure<Fd> saveFd(@RequestBody Fd fd)
	{
		return fdService.saveFd(fd);
	}
	
	@GetMapping("/fetchFdById")
	public ResponseStructure<Fd> fetchFdById(@RequestParam int fdId)
	{
		return fdService.fetchFdById(fdId);
	}
	
	@PutMapping("/updateFd")
	public ResponseStructure<Fd> updateFd(@RequestBody Fd fd,@RequestParam int oldFdId)
	{
		fd.setFdId(oldFdId);
		return fdService.saveFd(fd);
	}
	
	@DeleteMapping("/deleteFd")
	public ResponseStructure<Fd> deleteFd(@RequestParam int fdId) {
		return fdService.deleteFd(fdId);
	}
	
	@GetMapping("/fetchAllFd")
	public ResponseStructureList<Fd> fetchAllFd() {
		return fdService.fetchAllFd();
	}

}
