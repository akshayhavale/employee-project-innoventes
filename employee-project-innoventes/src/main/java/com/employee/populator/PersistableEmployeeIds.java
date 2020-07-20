package com.employee.populator;

import java.util.Date;
import java.util.List;

public class PersistableEmployeeIds {

	private long id;

	private String name;

	private Date dateOfBirth;

	private List<PersistableAddressids> addresses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date date_of_birth) {
		this.dateOfBirth = date_of_birth;
	}

	public List<PersistableAddressids> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<PersistableAddressids> addresses) {
		this.addresses = addresses;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
