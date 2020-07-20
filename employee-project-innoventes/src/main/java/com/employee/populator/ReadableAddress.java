package com.employee.populator;

public class ReadableAddress {

	private long id;

	private String addrLineOne;

	private String addrLineTwo;

	private String city;

	private String addressType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddrLineOne() {
		return addrLineOne;
	}

	public void setAddrLineOne(String addr_line_one) {
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

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String address_type) {
		this.addressType = address_type;
	}

}
