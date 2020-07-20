package com.employee.populator;

import java.util.Date;
import java.util.List;

public class ReadableEmployee {

	private long id;

	private String name;

	private Date dateOfBirth;

	private List<ReadableAddress> addresses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public List<ReadableAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<ReadableAddress> addresses) {
		this.addresses = addresses;
	}

}
