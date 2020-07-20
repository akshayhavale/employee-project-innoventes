package com.employee.facade;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Address;
import com.employee.model.Employee;
import com.employee.model.EmployeeAddress;
import com.employee.populator.PersistableAddressEmployee;
import com.employee.populator.PersistableAddressids;
import com.employee.populator.PersistableEmployeeAddress;
import com.employee.populator.PersistableEmployeeAddressPopulator;
import com.employee.populator.ReadableEmployee;
import com.employee.populator.ReadableEmployeePopulator;
import com.employee.services.EmployeeAddressService;
import com.employee.services.EmployeeService;

@Service
public class EmployeeAddressFacadeImpl implements EmployeeAddressFacade {

	@Autowired
	private EmployeeAddressService empAddrService;

	@Autowired
	private EmployeeService empService;

	@Override
	public ReadableEmployee updateEmployeeAddress(PersistableEmployeeAddress perEmpAddr, long empId) {

		Employee existEmployee = empService.getById(empId);

		Employee employee = new Employee();

		employee.setId(empId);
		employee.setDateOfBirth(existEmployee.getDateOfBirth());
		employee.setName(existEmployee.getName());

		Set<Address> addresses = new HashSet<Address>();
		Set<Address> existedAddresses = existEmployee.getAddresses();

		List<PersistableAddressEmployee> ped = perEmpAddr.getAddresses();
		for (PersistableAddressEmployee pae : ped) {
			Address address = new Address();
			for (Address addr : existedAddresses) {
				if (addr.getId() == pae.getId()) {
					address.setAddr_line_one(pae.getAddrLineOne());
					address.setAddrLineTwo(pae.getAddrLineTwo());
					address.setCity(pae.getCity());
					address.setId(addr.getId());
					addresses.add(address);
				}
			}

		}

		employee.setAddresses(addresses);

		Employee updatedEmployee = empService.createEmployee(employee);

		List<EmployeeAddress> existedEmpAdd = empAddrService.getAllEmpAddrDetailsByEmpId(empId);

		for (EmployeeAddress empAdd : existedEmpAdd) {
			EmployeeAddress updatableEmpAdd = new EmployeeAddress();
			for (PersistableAddressEmployee pad : ped) {
				if (pad.getId() == empAdd.getId()) {
					updatableEmpAdd.setId(empAdd.getId());
					updatableEmpAdd.setAddress(empAdd.getAddress());
					updatableEmpAdd.setEmployee(empAdd.getEmployee());
					updatableEmpAdd.setAddressType(pad.getAddressType());

					empAddrService.save(updatableEmpAdd);

				}
			}
		}

		List<EmployeeAddress> upatedEmpAdd = empAddrService.getAllEmpAddrDetailsByEmpId(empId);

		ReadableEmployeePopulator populator = new ReadableEmployeePopulator();

		return populator.populateWithAddrType(updatedEmployee, upatedEmpAdd);

	}

}
