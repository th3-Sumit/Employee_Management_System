package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Entity.EmployeeEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmployeeEntity, Integer>{

}
