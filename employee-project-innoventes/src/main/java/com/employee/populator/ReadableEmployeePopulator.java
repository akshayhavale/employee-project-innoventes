package com.employee.populator;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.employee.model.Address;
import com.employee.model.Employee;
import com.employee.model.EmployeeAddress;

import static java.util.Objects.nonNull;;

public class ReadableEmployeePopulator {

	public ReadableEmployee populate(Employee source) {

		ReadableEmployee target = new ReadableEmployee();

		target.setId(source.getId());
		target.setName(source.getName());
		target.setDateOfBirth(source.getDateOfBirth());

		List<ReadableAddress> readableAddress = new ArrayList<ReadableAddress>();

		Set<Address> addresses = source.getAddresses();
		
		

		for (Address address : addresses) {

			ReadableAddress ra = new ReadableAddress();

			ra.setId(address.getId());
			ra.setAddrLineOne(address.getAddr_line_one());
			ra.setAddrLineTwo(address.getAddrLineTwo());
			ra.setCity(address.getCity());

			readableAddress.add(ra);
		}

		target.setAddresses(readableAddress);

		return target;

	}

	public ReadableEmployee populateWithAddrType(Employee source, List<EmployeeAddress> savedList) {

		ReadableEmployee target = new ReadableEmployee();

		target.setId(source.getId());
		target.setName(source.getName());
		target.setDateOfBirth(source.getDateOfBirth());

		List<ReadableAddress> readableAddress = new ArrayList<ReadableAddress>();

		Set<Address> addresses = source.getAddresses();

		for (Address address : addresses) {

			ReadableAddress ra = new ReadableAddress();

			ra.setId(address.getId());
			ra.setAddrLineOne(address.getAddr_line_one());
			ra.setAddrLineTwo(address.getAddrLineTwo());
			ra.setCity(address.getCity());

			for (EmployeeAddress ea : savedList) {
				if (address.getId() == ea.getAddress()) {
					if (nonNull(ea.getAddressType())) {
						ra.setAddressType(ea.getAddressType());
					} else {
						ra.setAddressType(null);
					}
				}
			}

			readableAddress.add(ra);
		}

		target.setAddresses(readableAddress);

		return target;

	}

	

}
