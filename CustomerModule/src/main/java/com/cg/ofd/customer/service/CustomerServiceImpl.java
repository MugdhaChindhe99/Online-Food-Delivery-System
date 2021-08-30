/** 
 * @author:pragya
  
 */
package com.cg.ofd.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofd.customer.bean.Customer;
import com.cg.ofd.customer.dao.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return this.customerRepository.findAll();
	}

	@Override
	public void delete() {
		this.customerRepository.deleteAll();

	}

	@Override
	public Customer findById(int customerId) {
		return customerRepository.findAll().stream().filter(id -> id.getCustomerId() == customerId).findAny().get();

	}

	@Override
	public Boolean deleteById(int customerId) {
		this.customerRepository.deleteById(customerId);
		return true;
	}
}