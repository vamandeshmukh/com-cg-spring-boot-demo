package com.cg.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.spring.boot.demo.model.Employee;

@Repository
//public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

//	@Query("SELECT e FROM Employee e WHERE e.name = 1?")
	public Employee findByName(String name);

}
