package com.cg.spring.boot.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
public class EmployeeController {

	private final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	Employee emp = new Employee(101, "Vaman", 10.5);

	@GetMapping("/emp")
	public String emp() {
		LOG.info(emp.toString());
		return emp.toString();
	}

	@GetMapping("/empObj")
	public Employee empObj() {
		LOG.info("empObj");
		return emp;
	}

	@GetMapping("/empJson")
	public String empJson() {
		LOG.info("empJson");
		ObjectMapper mapper = new ObjectMapper();
		try {
			String empJson = mapper.writeValueAsString(emp);
			return empJson;
		} catch (JsonProcessingException e) {
			LOG.error("JsonProcessingException"); 
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/empGson")
	public String empGson() {
		LOG.info("empGson");
		Gson gson = new Gson();
		String empGson = gson.toJson(emp);
		return empGson;
	}

	@RequestMapping("/empList")
	public List<Employee> getAllEmployees() {
		LOG.info("empList");
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(101, "Vaman", 10.5));
		employeeList.add(new Employee(102, "Soman", 10.6));
		employeeList.add(new Employee(103, "Raman", 10.7));
		return employeeList;
	}
}
