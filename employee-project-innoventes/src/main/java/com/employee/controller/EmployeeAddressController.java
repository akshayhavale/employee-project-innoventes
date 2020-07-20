package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exceptions.ResourceNotFoundException;
import com.employee.facade.EmployeeAddressFacade;
import com.employee.populator.PersistableEmployeeAddress;
import com.employee.populator.ReadableEmployee;

@RestController
@RequestMapping("api/v1")
public class EmployeeAddressController {

	@Autowired
	private EmployeeAddressFacade empAddrFacade;

	@PatchMapping("/update/address/employee/{id}")
	public @ResponseBody ReadableEmployee updateAddress(@RequestBody PersistableEmployeeAddress persistableEmpAddr,
			@PathVariable(value = "id") long empId) throws ResourceNotFoundException {
		try {
			ReadableEmployee employee = empAddrFacade.updateEmployeeAddress(persistableEmpAddr, empId);
			if (employee == null) {
				throw new ResourceNotFoundException("NOT PROPER EMPLOYEE ID");
			} else {
				return employee;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NOT PROPER EMPLOYEE ID");
		}

	}

}
