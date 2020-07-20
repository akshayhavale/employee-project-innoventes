package com.employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.model.Employee;

@Service
public interface EmployeeService {

	public Employee createEmployee(Employee employee);

	public Employee getById(long id);

	public void deleteEmployee(long id);

	public List<Employee> getByname(String name);

	public Employee updateEmployee(Employee employee, long id);
	
	public List<Employee> getAllEmployee();

}
