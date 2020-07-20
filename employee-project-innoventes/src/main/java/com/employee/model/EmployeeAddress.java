package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_address")
public class EmployeeAddress {

	@Id
	@Column(name = "emp_addr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "emp_id")
	private long employee;

	@Column(name = "addr_id")
	private long address;

	@Column(name = "address_type")
	private String addressType = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String address_type) {
		this.addressType = address_type;
	}

	public long getEmployee() {
		return employee;
	}

	public void setEmployee(long empId) {
		this.employee = empId;
	}

	public long getAddress() {
		return address;
	}

	public void setAddress(long addrId) {
		this.address = addrId;
	}

}
