package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addr_id")
	private long id;

	@NotNull
	@Column(name = "addr_line_one", length = 250)
	private String addrLineOne;

	@Column(name = "addr_line_two", length = 250)
	private String addrLineTwo;

	@Column(name = "city")
	private String city;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddr_line_one() {
		return addrLineOne;
	}

	public void setAddr_line_one(String addr_line_one) {
		this.addrLineOne = addr_line_one;
	}

	public String getAddrLineTwo() {
		return addrLineTwo;
	}

	public void setAddrLineTwo(String addr_line_two) {
		this.addrLineTwo = addr_line_two;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
