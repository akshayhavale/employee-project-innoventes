package com.employee.populator;

import java.util.Date;
import java.util.List;

public class PersistableEmployee {
	
	private String name;
	
	private Date dateOfBirth;
	
	private List<PersistableAddress> addresses;

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

	public List<PersistableAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<PersistableAddress> addresses) {
		this.addresses = addresses;
	}
	
	

}
