package com.techyoda.company.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techyoda.company.entities.Department;
import com.techyoda.company.repositories.DepartmentRepository;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments(){
		return departmentRepository.findAll();
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable(value = "id") int id) {
		return departmentRepository.findById(id).get();
	}
	
	@PostMapping("/departments")
	@Transactional
	public Department createDepartment(@RequestBody Department department) {
		return departmentRepository.save(department);
	}
	
	@PutMapping("/departments")
	public Department updateDepartment(@RequestBody Department department) {
		return departmentRepository.save(department);
	}
	
	@DeleteMapping("/departments/{id}")
	public void deleteDepartment(@PathVariable(value = "id") int id) {
		departmentRepository.deleteById(id);
	}
}
