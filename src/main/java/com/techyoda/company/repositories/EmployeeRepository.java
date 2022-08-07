package com.techyoda.company.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techyoda.company.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByFirstName(String firstName);
	
}
