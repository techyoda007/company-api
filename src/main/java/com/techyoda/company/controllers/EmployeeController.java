package com.techyoda.company.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techyoda.company.entities.Employee;
import com.techyoda.company.repositories.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepositoy;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepositoy.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") int id) {
		return employeeRepositoy.findById(id).get();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepositoy.save(employee);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeRepositoy.save(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable(value = "id") int id) {
		employeeRepositoy.deleteById(id);
	}
	
	@GetMapping("/employees/byfirstname/{firstname}")
	public List<Employee> getEmployeesByName(@PathVariable(value = "firstname") String firstName){
		return employeeRepositoy.findByFirstName(firstName);
	}

}
