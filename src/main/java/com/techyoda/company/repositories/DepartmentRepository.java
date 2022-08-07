package com.techyoda.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techyoda.company.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
