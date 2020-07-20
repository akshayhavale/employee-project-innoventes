package com.employee.populator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.employee.model.Address;
import com.employee.model.Employee;

public class PersistableEmployeePopulator {

	public Employee populate(PersistableEmployee source) {

		Employee target = new Employee();

		target.setName(source.getName());
		target.setDateOfBirth(source.getDateOfBirth());

		Set<Address> addresses = new HashSet<Address>();

		List<PersistableAddress> persistableAddresses = source.getAddresses();

		for (PersistableAddress pa : persistableAddresses) {
			Address address = new Address();
			address.setAddr_line_one(pa.getAddrLineOne());
			address.setAddrLineTwo(pa.getAddrLineTwo());
			address.setCity(pa.getCity());
			addresses.add(address);
		}

		target.setAddresses(addresses);

		return target;

	}

}
