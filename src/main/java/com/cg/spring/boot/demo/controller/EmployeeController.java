package com.cg.spring.boot.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

//mark class as Controller
@RestController
public class EmployeeController {
//autowire the EmployeeService class
	@Autowired
	EmployeeService employeeService;

//creating a get mapping that retrieves all the Employee detail from the database
	@GetMapping("/Employee")
	private List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

//creating a get mapping that retrieves the detail of a specific Employee
	@GetMapping("/Employee/{eid}")
	private Employee getEmployee(@PathVariable("eid") int eid) {
		return employeeService.getEmployeeById(eid);
	}

//creating a delete mapping that deletes a specified Employee
	@DeleteMapping("/Employee/{eid}")
	private void deleteEmployee(@PathVariable("eid") int eid) {
		employeeService.delete(eid);
	}

//creating post mapping that post the Employee detail in the database
	@PostMapping("/Employee")
	private int saveEmployee(@RequestBody Employee Employee) {
		employeeService.saveOrUpdate(Employee);
		return Employee.getEid();
	}

//creating put mapping that updates the Employee detail
	@PutMapping("/Employee")
	private Employee update(@RequestBody Employee Employee) {
		employeeService.saveOrUpdate(Employee);
		return Employee;
	}
}

//package com.cg.spring.boot.demo.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cg.spring.boot.demo.model.Employee;
//import com.cg.spring.boot.demo.service.EmployeeService;
//
////mark class as Controller
//@RestController
//public class EmployeeController {
//
//	private final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
//
//	// autowire the EmployeeService class
//	@Autowired
//	EmployeeService employeeService;
//
//	// RresponseBody example
//	@PostMapping("/sample")
//	@ResponseBody
//	private String sample(@RequestBody String name) {
//		LOG.info(name);
//		String str = "Some String Value";
//		return str;
//	}
//
//	// creating a get mapping that retrieves all the Employee detail from the
//	// database
//	@GetMapping("/Employee")
//	private List<Employee> getAllEmployee() {
//		LOG.info("getAllEmployee");
//		return employeeService.getAllEmployee();
//	}
//
////creating a get mapping that retrieves the detail of a specific Employee
//	@GetMapping("/Employee/{eid}")
////	private Employee getEmployee(@PathVariable("eid") String eid) {
//	private Employee getEmployee(@PathVariable("eid") int eid) {
//		LOG.info("getEmployee");
////		return employeeService.getEmployeeById(Integer.parseInt(eid));
//		return employeeService.getEmployeeById(eid);
//	}
//
////creating a delete mapping that deletes a specified Employee
//	@DeleteMapping("/Employee/{eid}")
//	private void deleteEmployee(@PathVariable("eid") int eid) {
//		LOG.info("deleteEmployee");
//		employeeService.delete(eid);
//	}
//
////creating post mapping that post the Employee detail in the database
//	@PostMapping("/Employee")
//	private int saveEmployee(@RequestBody Employee Employee) {
//		LOG.info("saveEmployee");
//		employeeService.saveOrUpdate(Employee);
//		return 100;
//	}
//
////creating put mapping that updates the Employee detail
//	@PutMapping("/Employee")
//	private Employee update(@RequestBody Employee Employee) {
//		employeeService.saveOrUpdate(Employee);
//		return Employee;
//	}
//}
