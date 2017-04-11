package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.persistence.Employee;
import com.example.services.EmployeeService;

@Controller
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping(value = "/save")
	public void saveEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("First");
		employee.setLastName("Last");
		employee.setCity("Pune");
		employee.setCountry("India");

		employeeService.saveOrUpdate(employee);
	}

	@GetMapping(value = "/delete")
	public void deleteEmployee(@RequestParam("employeeId") Long employeeId) {
		employeeService.delete(employeeId);
	}

	@GetMapping(value= "/getAll")
	@ResponseBody
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}
}
