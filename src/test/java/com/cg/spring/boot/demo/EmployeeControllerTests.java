package com.cg.spring.boot.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.cg.spring.boot.demo.model.Employee;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void empShouldReturnEmp() throws Exception {
		assertThat(
				this.restTemplate.getForObject("http://localhost:" + port + "/employee/getThisEmp/121", String.class))
						.contains("This Employee does not exist.");
	}

	@Test
	public void empShouldReturnThisEmp() throws Exception {
		assertEquals(this.restTemplate
				.getForObject("http://localhost:" + port + "/employee/getThisEmp/112", Employee.class).toString(),
				new Employee(112, "R", 7482).toString());
	}

	@Test
	public void empShouldNotReturnThisEmp() throws Exception {
		assertNotEquals(this.restTemplate
				.getForObject("http://localhost:" + port + "/employee/getThisEmp/112", Employee.class).toString(),
				new Employee(112, "R", 7482).toString());
	}

}