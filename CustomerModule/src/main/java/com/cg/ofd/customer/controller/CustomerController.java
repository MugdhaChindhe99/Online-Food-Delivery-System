/** 
 * @author:pragya
  
 */
package com.cg.ofd.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.customer.bean.Customer;
import com.cg.ofd.customer.exception.CustomerNotFoundException;
import com.cg.ofd.customer.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "/customer", tags = " Customer Controller")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@ApiOperation(value = "Insert customer details", response = Customer.class)
	@PostMapping("/addCustomer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) { //method to add the customer details
		logger.info("Inside addCustomer() method of Customer Controller");

		return this.customerService.saveCustomer(customer);
	}

	@ApiOperation(value = "Update customer details", response = Customer.class)
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {//method to update the customer details
		logger.info("Inside updateCustomer() method of Customer Controller");
		return this.customerService.updateCustomer(customer);
	}

	@ApiOperation(value = "Fetch all customers", response = Iterable.class)
	@GetMapping("/all")
	public List<Customer> getAllCustomer() {//method to fetch all customers details
		logger.info("Inside getAllCustomer() method of Customer Controller");
		List<Customer> customers = this.customerService.findAllCustomer();
		if (customers.isEmpty())
			throw new CustomerNotFoundException("List of Customers not found");
		else
			return customers;
	}

	@ApiOperation(value = "Fetch Customer by Id", response = Customer.class)
	@GetMapping("/search/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {//method to fetch customer details by customer Id
		logger.info("Inside getCustomerById() method of Customer Controller");
		Customer customer = this.customerService.findById(customerId);
		if (customer == null)
			throw new CustomerNotFoundException("Customer with customer Id:" + customerId + "does not exist");
		else
			return customer;

	}

	@ApiOperation(value = "Delete customer by Id", response = Customer.class)
	@DeleteMapping("/delete/{customerId}")
	public void deleteById(@PathVariable int customerId) {//method to delete customer by Id
		logger.info("Inside deleteById() method of Customer Controller");
		Customer customer = customerService.findById(customerId);
		if (customer == null)
			throw new CustomerNotFoundException("Customer with customer Id:" + customerId + "does not exist");
		else {
			this.customerService.deleteById(customerId);
			System.out.println("Customer with customer Id" + customerId + "removed successfully from the database");
		}

	}

	@ApiOperation(value = "Delete all Customer Details", response = Customer.class)
	@DeleteMapping("/delete/all")
	public void deleteAll() {
		this.customerService.delete();
	}
}
