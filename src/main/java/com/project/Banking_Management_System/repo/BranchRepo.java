package com.project.Banking_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Banking_Management_System.dto.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer>{
	
	

}
