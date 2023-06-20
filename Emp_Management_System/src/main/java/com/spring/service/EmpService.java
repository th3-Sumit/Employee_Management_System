package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Entity.EmployeeEntity;
import com.spring.repository.EmpRepository;

@Service
public class EmpService{
	
	@Autowired
	private EmpRepository repo;
	public void addEmp(EmployeeEntity e) {
		repo.save(e);
	}
	
	public List<EmployeeEntity> getAllEmp(){
		return repo.findAll();
	}
	
	public EmployeeEntity getEmpById(int id) {
		Optional<EmployeeEntity> e = repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		
		return null;
	}
	
	public void deleteEmp(int id) {
		repo.deleteById(id);
	}
}
