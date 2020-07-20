package com.employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.model.EmployeeAddress;

@Service
public interface EmployeeAddressService {

	public EmployeeAddress update(EmployeeAddress employeeAddress);

	public List<EmployeeAddress> getAllEmpAddrDetailsByEmpId(long empId);

	public List<EmployeeAddress> update(List<EmployeeAddress> persistList, long empId);

	public void save(EmployeeAddress empAddr);

	public void deleteEmployee(long empid);

	


}
