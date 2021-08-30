package com.cg.ofd.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.cg.ofd.customer.service.CustomerServiceImpl;
import com.cg.ofd.customer.bean.Address;
import com.cg.ofd.customer.bean.Customer;
import com.cg.ofd.customer.service.CustomerService;

public class CustomerTests {

	@Test
	public void addTest() {
		Address address = new Address(530, "Menakshi", "lane3", "hadapsar", "pune", "ms", "india", "411041");
		Customer cust1 = new Customer(4, "Pragya", "Naruka", "Female", "22", "7976861931", "pragyas.naruka@gmail.com",
				address);

		CustomerService customerService = mock(CustomerServiceImpl.class);

		when(customerService.saveCustomer(cust1)).thenReturn(cust1);

		Customer cust2 = customerService.saveCustomer(cust1);

		assertEquals(cust1, cust2);

	}

	@Test
	public void updateCustomer() {
		Address address = new Address(51, "Menakshi", "lane3", "hadapsar", "pune", "ms", "india", "411041");
		Customer cust1 = new Customer(50, "Pragya", "Naruka", "Female", "22", "7976861931", "pragyas.naruka@gmail.com",
				address);

		CustomerService customerService = mock(CustomerServiceImpl.class);

		customerService.saveCustomer(cust1);

		Customer cust2 = new Customer(50, "Khushi", "Naruka", "Female", "22", "7976861931", "pragyas.naruka@gmail.com",
				address);

		when(customerService.updateCustomer(cust2)).thenReturn(cust2);
		Customer cust3 = customerService.updateCustomer(cust2);
		assertEquals(cust2, cust3);

	}

	@Test
	public void findCustomer() {
		Address address = new Address(51, "Menakshi", "lane3", "hadapsar", "pune", "ms", "india", "411041");
		Customer cust1 = new Customer(50, "Pragya", "Naruka", "Female", "22", "7976861931", "pragyas.naruka@gmail.com",
				address);

		CustomerService customerService = mock(CustomerServiceImpl.class);

		customerService.saveCustomer(cust1);

		when(customerService.findById(50)).thenReturn(cust1);

		Customer cust2 = customerService.findById(50);

		assertEquals("Pragya", cust2.getFirstName());

	}

	@Test
	public void removeById() {
		Address address = new Address(530, "Menakshi", "lane3", "hadapsar", "pune", "ms", "india", "411041");
		Customer cust1 = new Customer(50, "Pragya", "Naruka", "Female", "22", "7976861931", "pragyas.naruka@gmail.com",
				address);

		CustomerService customerService = mock(CustomerServiceImpl.class);
		customerService.saveCustomer(cust1);

		when(customerService.deleteById(50)).thenReturn(Boolean.TRUE);
		Boolean cust2 = customerService.deleteById(50);
		assertEquals(Boolean.TRUE, cust2);

	}

}
