package com.cg.spring.boot.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.spring.boot.demo.exceptions.EmployeeNotfoundException;
import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;
import com.cg.spring.boot.demo.service.EmployeeService;

//mark class as Controller
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4201")
public class EmployeeController {
//autowire the EmployeeService class

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	@CrossOrigin
	@GetMapping("/getThisEmp/{eid}")
	public ResponseEntity<Employee> getThisEmp(@PathVariable("eid") int eid) {
		Employee emp = employeeService.getEmployeeById(eid);
		if (emp == null)
			throw new EmployeeNotfoundException();
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	// paging and sorting demo endpoint

	@GetMapping(value = { "getEmpList", "/" })
	public @ResponseBody Page<Employee> getEmpList(Pageable pageable) {

		return employeeService.getEmpList(pageable);

	}

//creating a get mapping that retrieves all the Employee detail from the database
	@GetMapping("/getAllEmployee")
	private List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

//creating a get mapping that retrieves the detail of a specific Employee
	@GetMapping("/getEmployee/{eid}")
	private Employee getEmployee(@PathVariable("eid") int eid) {
		return employeeService.getEmployeeById(eid);
	}

	@GetMapping("/getEmpByName/{name}")
	private Employee getEmployee(@PathVariable("name") String name) {
		return employeeService.getEmployeeByName(name);
	}

	// creating a delete mapping that deletes a specified Employee
	@DeleteMapping("/deleteEmployee/{eid}")
	private void deleteEmployee(@PathVariable("eid") int eid) {
		employeeService.delete(eid);
	}

//creating post mapping that post the Employee detail in the database
	@PostMapping("/saveEmployee")
	private int saveEmployee(@RequestBody Employee Employee) {
		employeeService.saveOrUpdate(Employee);
//		employeeService.
		return Employee.getEid();
	}

////creating put mapping that updates the Employee detail
//	@PutMapping("/Employee")
//	private Employee update(@RequestBody Employee Employee) {
//		employeeService.saveOrUpdate(Employee);
//		return Employee;
//	}
//}

//creating put mapping that updates the Employee detail
	@PutMapping("/updateEmployee")
	private Employee updateEmployee(@RequestBody Employee Employee) {
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
// @GetMapping("/getEmpSort/{sort1}/{sort2}")
//@ResponseBody
//public List<Employee> getEmpSort(@PathVariable String sort1, @PathVariable String sort2) {
//	List<Employee> emp = (List<Employee>) employeeService.getEmpSort(sort1, sort2);
//	return emp;
//}

//}
