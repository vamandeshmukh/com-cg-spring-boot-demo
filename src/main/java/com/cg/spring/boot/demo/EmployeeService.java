package com.cg.spring.boot.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//defining the business logic
@Service
public class EmployeeService {
//	@Autowired
//	EmployeeRepository employeeRepository;
	private List<Employee> employeeList = new ArrayList<Employee>();

	{
		employeeList.add(new Employee(101, "Sonu", 10.5));
		employeeList.add(new Employee(102, "Monu", 20.25));
		employeeList.add(new Employee(103, "Tonu", 15.75));
		employeeList.add(new Employee(104, "Ponu", 18.00));
		employeeList.add(new Employee(105, "Gonu", 12.5));
	}

//getting all Employee record by using the method findaAll() of CrudRepository
	public List<Employee> getAllEmployee() {
//		employeeRepository.findAll().forEach(employee1 -> employeeList.add(employee1));
		return employeeList;
	}

//getting a specific record by using the method findById() of CrudRepository
	public Employee getEmployeeById(int id) {
//		return employeeRepository.findById(id).get();
		return employeeList.stream().filter(emp -> id == emp.getEid()).findAny().orElse(null);
//		return null;
	}

//saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Employee employee) {
//		employeeRepository.save(employeeList);
		employeeList.add(employee);

	}

//deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id) {
		employeeList.removeIf(emp -> emp.getEid() == id);
	}

//updating a record
	public void update(Employee employee, int eid) {
//		employeeRepository.save(employee);
//		employeeList.set(employeeList.indexOf(eid), employee);
	}
}
