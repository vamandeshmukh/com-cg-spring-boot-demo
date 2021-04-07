package com.cg.spring.boot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
// this is a comment 

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

public class EmployeeServiceTests {

	@Autowired
	private EmployeeService service;

	public void testGetEmployee() {
		Employee expected = service.getEmployeeById(101);
		Employee actual = new Employee(101, "Sonu", 10.5);
		assertEquals(expected, actual);
	}

}
