package com.employee.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.populator.PersistableEmployee;
import com.employee.populator.PersistableEmployeeIds;
import com.employee.populator.ReadableEmployee;

@Service
public interface EmployeeFacade {

	public ReadableEmployee createEmployee(PersistableEmployee persistableEmployee);

	public ReadableEmployee getById(long empid);

	public ReadableEmployee update(PersistableEmployeeIds persitableEmployee, long empid);

	public List<ReadableEmployee> getAll();

	public void deleteEmployeeById(long empid);

	public List<ReadableEmployee> getByEmployeeByName(String name);

}
