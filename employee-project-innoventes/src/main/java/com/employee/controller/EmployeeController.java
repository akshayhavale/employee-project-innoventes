package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exceptions.ExceptionHandling;
import com.employee.exceptions.ResourceNotFoundException;
import com.employee.facade.EmployeeFacade;
import com.employee.model.Employee;
import com.employee.populator.PersistableEmployee;
import com.employee.populator.PersistableEmployeeIds;
import com.employee.populator.ReadableEmployee;
import com.employee.services.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeFacade employeeFacade;

	@PostMapping("/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody ReadableEmployee createEmployee(@RequestBody PersistableEmployee persitableEmployee)
			throws ExceptionHandling {
		try {
			ReadableEmployee employee = employeeFacade.createEmployee(persitableEmployee);
			if (employee == null) {
				throw new Exception("Wrong Input");
			} else {
				return employee;
			}
		} catch (Exception e) {
			throw new ExceptionHandling("Wrong Datas Input");
		}
	}

	@GetMapping("/employee/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody ReadableEmployee get(@PathVariable(name = "id") long empid) throws ResourceNotFoundException {
		try {
			ReadableEmployee employee = employeeFacade.getById(empid);
			if (employee == null) {
				throw new ResourceNotFoundException("NOT PROPER EMPLOYEE ID");
			} else {
				return employee;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NOT PROPER EMPLOYEE ID");
		}
	}

	@PutMapping("/employee/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody ReadableEmployee update(@PathVariable(name = "id") long empid,
			@RequestBody PersistableEmployeeIds persitableEmployee) throws ResourceNotFoundException {
		try {

			ReadableEmployee employee = employeeFacade.update(persitableEmployee, empid);
			if (employee == null) {
				throw new ResourceNotFoundException("NOT PROPERLY UPDATED");
			} else {
				return employee;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NOT PROPERLY UPDATED");
		}

	}

	@GetMapping("/employee/all")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody List<ReadableEmployee> getAll() throws ResourceNotFoundException {
		try {

			List<ReadableEmployee> list = employeeFacade.getAll();
			if (list == null) {
				throw new ResourceNotFoundException("NO DATA FOUND");
			} else {
				return list;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NO DATA FOUND");
		}
	}

	@DeleteMapping("/employee/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteEmployee(@PathVariable(value = "id") long empid) {
		employeeFacade.deleteEmployeeById(empid);
	}


	@GetMapping("/employee/name/{name}")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody List<ReadableEmployee> getByName(@PathVariable(value = "name") String name)
			throws ResourceNotFoundException {
		try {

			List<ReadableEmployee> list = employeeFacade.getByEmployeeByName(name);
			if (list == null) {
				throw new ResourceNotFoundException("NO DATA FOUND");
			} else {
				return list;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NO DATA FOUND");
		}
	}

}
