package com.employee.facade;

import org.springframework.stereotype.Service;

import com.employee.populator.PersistableEmployeeAddress;
import com.employee.populator.ReadableEmployee;

@Service
public interface EmployeeAddressFacade {
	
	public ReadableEmployee updateEmployeeAddress(PersistableEmployeeAddress perEmpAddr, long empId);

}
