package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeAddress;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Long> {

	List<EmployeeAddress> findByEmployee(long empId);

	void deleteByEmployee(long empid);

//	EmployeeAddress findByAddrId(long id);

}
