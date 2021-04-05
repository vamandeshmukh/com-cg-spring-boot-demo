package com.cg.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.spring.boot.demo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

//	public void findByLasName(String lastName);

	// public interface EmployeeRepository extends JpaRepository<Employee, Integer>
	// {

}
