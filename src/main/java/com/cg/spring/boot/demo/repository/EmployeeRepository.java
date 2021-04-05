package com.cg.spring.boot.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.spring.boot.demo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
