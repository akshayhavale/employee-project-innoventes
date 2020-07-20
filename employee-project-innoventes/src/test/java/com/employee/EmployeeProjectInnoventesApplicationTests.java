package com.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.employee.populator.PersistableAddress;
import com.employee.populator.PersistableEmployee;
import com.employee.populator.ReadableEmployee;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeProjectInnoventesApplicationTests {

	// creating employee
	@Test
	public void createEmployee() {

		final String url = "http://localhost:8080/api/v1/employee";

		RestTemplate rest = new RestTemplate();

		PersistableEmployee entity = new PersistableEmployee();

		entity.setName("DEVID");
		entity.setDateOfBirth(new Date(1980, 05, 22));
		List<PersistableAddress> addresses = new ArrayList<PersistableAddress>();

		PersistableAddress address1 = new PersistableAddress();
		address1.setAddrLineOne("1ST LINE");
		address1.setAddrLineTwo("2ND LINE");
		address1.setCity("CITY");

		PersistableAddress address2 = new PersistableAddress();
		address2.setAddrLineOne("1ST LINE");
		address2.setAddrLineTwo("2ND LINE");
		address2.setCity("CITY");

		addresses.add(address1);
		addresses.add(address2);

		entity.setAddresses(addresses);

		HttpEntity<PersistableEmployee> request = new HttpEntity<PersistableEmployee>(entity);

		ResponseEntity<ReadableEmployee> response = rest.postForEntity(url, request, ReadableEmployee.class);
		System.out.println(response.getBody().getName());

//		assertEquals(200, response.getStatusCodeValue());

		assertEquals(201, response.getStatusCodeValue());
	}

	// get employee by id
	@Test
	public void getEmployeeById() throws URISyntaxException {

		final String url = "http://localhost:8080/api/v1/employee";

		RestTemplate rest = new RestTemplate();

		PersistableEmployee entity = new PersistableEmployee();

		entity.setName("DEVID");
		entity.setDateOfBirth(new Date(1980, 05, 22));
		List<PersistableAddress> addresses = new ArrayList<PersistableAddress>();

		PersistableAddress address1 = new PersistableAddress();
		address1.setAddrLineOne("1ST LINE");
		address1.setAddrLineTwo("2ND LINE");
		address1.setCity("CITY");

		PersistableAddress address2 = new PersistableAddress();
		address2.setAddrLineOne("1ST LINE");
		address2.setAddrLineTwo("2ND LINE");
		address2.setCity("CITY");

		addresses.add(address1);
		addresses.add(address2);

		entity.setAddresses(addresses);

		HttpEntity<PersistableEmployee> request = new HttpEntity<PersistableEmployee>(entity);

		ResponseEntity<ReadableEmployee> response = rest.postForEntity(url, request, ReadableEmployee.class);
		System.out.println(response.getBody().getName());

		final String url1 = "http://localhost:8080/api/v1/employee/1";

		RestTemplate rest1 = new RestTemplate();

		ResponseEntity<ReadableEmployee> response1 = rest1.getForEntity(url1, ReadableEmployee.class, 1);

		assertEquals(200, response1.getStatusCodeValue());

	}

	// get employee by name
	@Test
	public void getEmployeeByName() {

		final String url = "http://localhost:8080/api/v1/employee/name/devid";

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		assertEquals(200, response.getStatusCodeValue());

	}

	// get all employee
	@Test
	public void getAll() {

		final String url = "http://localhost:8080/api/v1/employee/all";

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		assertEquals(200, response.getStatusCodeValue());

	}

	// updating Employee employee
	@Test
	public void updateEmployeeByEmployeeId() {

		final String url = "http://localhost:8080/api/v1/employee";

		RestTemplate rest = new RestTemplate();

		PersistableEmployee entity = new PersistableEmployee();

		entity.setName("DEVID");
		entity.setDateOfBirth(new Date(1980, 05, 22));
		List<PersistableAddress> addresses = new ArrayList<PersistableAddress>();

		PersistableAddress address1 = new PersistableAddress();
		address1.setAddrLineOne("1ST LINE");
		address1.setAddrLineTwo("2ND LINE");
		address1.setCity("CITY");

		PersistableAddress address2 = new PersistableAddress();
		address2.setAddrLineOne("1ST LINE");
		address2.setAddrLineTwo("2ND LINE");
		address2.setCity("CITY");

		addresses.add(address1);
		addresses.add(address2);

		entity.setAddresses(addresses);

		HttpEntity<PersistableEmployee> request = new HttpEntity<PersistableEmployee>(entity);

		ResponseEntity<ReadableEmployee> response = rest.postForEntity(url, request, ReadableEmployee.class);
		System.out.println(response.getBody().getName());

		final String url1 = "http://localhost:8080/api/v1/employee/1";

		RestTemplate rest1 = new RestTemplate();

		PersistableEmployee entity1 = new PersistableEmployee();

		entity1.setName("JOE");
		entity1.setDateOfBirth(new Date(1980, 05, 22));
		List<PersistableAddress> addresses1 = new ArrayList<PersistableAddress>();

		PersistableAddress address3 = new PersistableAddress();
		address1.setAddrLineOne("2ND LINE");
		address1.setAddrLineTwo("1ST LINE");
		address1.setCity("CITY1");
		address1.setAddressType("Residence");

		PersistableAddress address4 = new PersistableAddress();
		address2.setAddrLineOne("2ND LINE");
		address2.setAddrLineTwo("1ST LINE");
		address2.setCity("CITY2");
		address2.setAddressType(" Billing address");

		addresses1.add(address3);
		addresses1.add(address4);

		entity1.setAddresses(addresses1);

		HttpEntity<PersistableEmployee> request1 = new HttpEntity<PersistableEmployee>(entity1);

		rest.put(url1, request1, 1);

	}

	// Delete By Employee Id
	@Test
	public void deleteByEmpId() {

		final String url = "http://localhost:8080/api/v1/employee/1";

		RestTemplate rest = new RestTemplate();

		rest.delete(url, 1);

	}

}
