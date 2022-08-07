package com.techyoda.company;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techyoda.company.entities.Department;
import com.techyoda.company.entities.Employee;

@SpringBootTest
class CompanyApiApplicationTests {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Test
	void testGetEmployees() {
		String url="http://localhost:8080/company/employees";
		
		ResponseEntity<Employee[]> response = restTemplate.getForEntity(url, Employee[].class);
		Employee[] employee = response.getBody();
		
		assertNotNull(employee);
		
		System.out.println(employee[1].getFirstName());
	}
	
	@Test
	public void testGetEmployee() {
		
		String url="http://localhost:8080/company/employees/1";
		
		Employee employee = restTemplate.getForObject(url, Employee.class);
		assertNotNull(employee);
	}
	
	@Test
	public void testCreateDepartment() {
		String url="http://localhost:8080/company/departments";
		Department department = new Department();
		department.setName("Sales");
		department.setHeadOfDepartment("Kevin J");
		
		Department createdDepartment = restTemplate.postForObject(url, department, Department.class);
		
		assertNotNull(createdDepartment);
	}
	//

}
