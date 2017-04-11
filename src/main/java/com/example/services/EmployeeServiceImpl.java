package com.example.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.persistence.Employee;
import com.example.persistence.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public void saveOrUpdate(Employee employee) {

		Employee newEmployee;
		if (Objects.nonNull(employee.getId())) {
			newEmployee = getById(employee.getId());
			newEmployee.setFirstName(employee.getFirstName());
			newEmployee.setLastName(employee.getLastName());
			newEmployee.setCity(employee.getCity());
			newEmployee.setCountry(employee.getCountry());
		} else {
			newEmployee = employee;
		}

		employeeRepo.save(newEmployee);
	}

	@Override
	public void delete(Long employeeId) {
		if (Objects.nonNull(employeeId)) {
			Employee employee = employeeRepo.findOne(employeeId);

			if (Objects.nonNull(employee)) {
				employeeRepo.delete(employee);
			}
		}
	}

	@Override
	public Employee getById(Long id) {
		return employeeRepo.findOne(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

}
