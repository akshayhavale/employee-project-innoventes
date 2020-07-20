package com.employee.facade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Address;
import com.employee.model.Employee;
import com.employee.model.EmployeeAddress;
import com.employee.populator.PersistableAddressids;
import com.employee.populator.PersistableEmployee;
import com.employee.populator.PersistableEmployeeIds;
import com.employee.populator.PersistableEmployeePopulator;
import com.employee.populator.ReadableEmployee;
import com.employee.populator.ReadableEmployeePopulator;
import com.employee.services.EmployeeAddressService;
import com.employee.services.EmployeeService;

@Service
public class EmployeeFacadeImpl implements EmployeeFacade {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeAddressService empAddrService;

	@Override
	public ReadableEmployee createEmployee(PersistableEmployee persistableEmployee) {

		PersistableEmployeePopulator persitPopulator = new PersistableEmployeePopulator();

		Employee employee = persitPopulator.populate(persistableEmployee);

		Employee savedEntity = employeeService.createEmployee(employee);

		Set<Address> addresses = savedEntity.getAddresses();

		for (Address addr : addresses) {
			EmployeeAddress empAddr = new EmployeeAddress();

			empAddr.setAddress(addr.getId());
			empAddr.setEmployee(savedEntity.getId());
			empAddr.setAddressType(null);

			empAddrService.save(empAddr);
		}

		ReadableEmployeePopulator readablePopulator = new ReadableEmployeePopulator();

		return readablePopulator.populate(savedEntity);

	}

	@Override
	public ReadableEmployee getById(long empid) {

		Employee empl = employeeService.getById(empid);

		List<EmployeeAddress> empAddr = empAddrService.getAllEmpAddrDetailsByEmpId(empid);

		ReadableEmployeePopulator readablePopulator = new ReadableEmployeePopulator();

		return readablePopulator.populateWithAddrType(empl, empAddr);
	}

	@Override
	public ReadableEmployee update(PersistableEmployeeIds persitableEmployee, long empid) {

		Employee empl = employeeService.getById(empid);

		Employee employee = new Employee();

		employee.setId(empl.getId());
		employee.setName(persitableEmployee.getName());
		employee.setDateOfBirth(persitableEmployee.getDateOfBirth());

		Set<Address> addresses = new HashSet<Address>();
		Set<Address> existedAddress = empl.getAddresses();
		List<PersistableAddressids> upadateAdd = persitableEmployee.getAddresses();

		for (PersistableAddressids padd : upadateAdd) {
			Address address = new Address();
			for (Address existAdd : existedAddress) {
				if (existAdd.getId() == padd.getId()) {
					address.setAddr_line_one(padd.getAddrLineOne());
					address.setAddrLineTwo(padd.getAddrLineTwo());
					address.setId(existAdd.getId());
					address.setCity(padd.getCity());
					addresses.add(address);

				}
			}
		}

		employee.setAddresses(addresses);

		Employee updatedEmployee = employeeService.createEmployee(employee);

		List<EmployeeAddress> existedEmpAdd = empAddrService.getAllEmpAddrDetailsByEmpId(empid);

		for (EmployeeAddress empAdd : existedEmpAdd) {
			EmployeeAddress updatableEmpAdd = new EmployeeAddress();
			for (PersistableAddressids pad : upadateAdd) {
				if (pad.getId() == empAdd.getId()) {
					updatableEmpAdd.setId(empAdd.getId());
					updatableEmpAdd.setAddress(empAdd.getAddress());
					updatableEmpAdd.setEmployee(empAdd.getEmployee());
					updatableEmpAdd.setAddressType(pad.getAddressType());

					empAddrService.save(updatableEmpAdd);

				}
			}
		}

		List<EmployeeAddress> upatedEmpAdd = empAddrService.getAllEmpAddrDetailsByEmpId(empid);

		ReadableEmployeePopulator populator = new ReadableEmployeePopulator();

		return populator.populateWithAddrType(updatedEmployee, upatedEmpAdd);

	}

	@Override
	public List<ReadableEmployee> getAll() {

		List<ReadableEmployee> target = new ArrayList<ReadableEmployee>();

		List<Employee> listEmployees = employeeService.getAllEmployee();
		for (Employee empl : listEmployees) {

			List<EmployeeAddress> empAddr = empAddrService.getAllEmpAddrDetailsByEmpId(empl.getId());

			ReadableEmployeePopulator readablePopulator = new ReadableEmployeePopulator();

			ReadableEmployee re = readablePopulator.populateWithAddrType(empl, empAddr);
			target.add(re);
		}

		return target;
	}

	@Override
	public void deleteEmployeeById(long empid) {
		try {
			empAddrService.deleteEmployee(empid);
			employeeService.deleteEmployee(empid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<ReadableEmployee> getByEmployeeByName(String name) {
		
		List<ReadableEmployee> target = new ArrayList<ReadableEmployee>();
		
		List<Employee> listEmployees = employeeService.getByname(name);
		for (Employee empl : listEmployees) {

			List<EmployeeAddress> empAddr = empAddrService.getAllEmpAddrDetailsByEmpId(empl.getId());

			ReadableEmployeePopulator readablePopulator = new ReadableEmployeePopulator();

			ReadableEmployee re = readablePopulator.populateWithAddrType(empl, empAddr);
			target.add(re);
		}
		return target;
	}

}
