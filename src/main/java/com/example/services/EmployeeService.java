package com.example.services;

import java.util.List;

import com.example.persistence.Employee;

public interface EmployeeService {

	void saveOrUpdate(Employee employee);

	void delete(Long employeeId);

	Employee getById(Long id);
	
	List<Employee> findAll();

}
