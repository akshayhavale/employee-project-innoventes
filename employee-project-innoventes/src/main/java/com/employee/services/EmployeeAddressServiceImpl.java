package com.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.EmployeeAddress;
import com.employee.repository.EmployeeAddressRepository;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

	@Autowired
	private EmployeeAddressRepository empAddrRepo;

	@Override
	public EmployeeAddress update(EmployeeAddress employeeAddress) {

		return empAddrRepo.save(employeeAddress);
	}

	@Override
	public List<EmployeeAddress> getAllEmpAddrDetailsByEmpId(long empId) {

		return empAddrRepo.findByEmployee(empId);
	}

	@Override
	public List<EmployeeAddress> update(List<EmployeeAddress> persistList, long empId) {

		for (EmployeeAddress empAddr : persistList) {
			empAddrRepo.save(empAddr);
		}

		return empAddrRepo.findByEmployee(empId);
	}

	@Override
	public void save(EmployeeAddress empAddr) {
		
		empAddrRepo.save(empAddr);
	}

	@Override
	public void deleteEmployee(long empid) {
		
		List<EmployeeAddress> empAdd = empAddrRepo.findByEmployee(empid);
		
		for(EmployeeAddress ad :empAdd) {
			try {
				empAddrRepo.delete(ad);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
