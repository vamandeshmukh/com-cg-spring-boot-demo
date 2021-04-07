package com.cg.spring.boot.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

//defining the business logic
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Page<Employee> getEmpList(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

	// getting all Employee record by using the method findaAll() of CrudRepository
	public List<Employee> getAllEmployees() {
		List<Employee> employee = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employee1 -> employee.add(employee1));
		return employee;
	}

//getting a specific record by using the method findById() of CrudRepository
	public Employee getEmployeeById(int id) {
		// logic
		try {
			return employeeRepository.findById(id).get();
		} catch (NoSuchElementException nse) {
//			throw new CustomException();
//			LOG.info();
			return null;
		} catch (Exception ex) {
			// LOG.info();
			return null;
		}
	}

	public Employee getEmployeeByName(String name) {

//		employeeRepository.f

		return employeeRepository.findByName(name);
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Employee employee) {
		employeeRepository.save(employee);
//		employeeRepository.
	}

//deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

//updating a record
	public void update(Employee employee, int eid) {
		employeeRepository.save(employee);
	}

//	public List<Employee> getEmpSort(String sort1, String sort2) {
//	List<String> sortField = new ArrayList<String>();
//	sortField.add(sort1);
//	sortField.add(sort2);
////	Sort sort = new Sort(Direction.ASC, sortField);
//	// another way to sort
//	Sort sort = Sort.by(sort1).ascending().and(Sort.by(sort2).descending());
//	List<Employee> emp = (List<Employee>) employeeRepository.findAll(sort);
//	return emp;
//}

}
