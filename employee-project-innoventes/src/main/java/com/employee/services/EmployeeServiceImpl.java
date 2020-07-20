package com.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Employee getById(long id) {

		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployee(long id) {

		employeeRepository.deleteById(id);

	}

	@Override
	public List<Employee> getByname(String name) {

		return employeeRepository.findByName(name);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
//		employee.setId(id);
//		return employeeRepository.save(employee);
		return null;

	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

}
