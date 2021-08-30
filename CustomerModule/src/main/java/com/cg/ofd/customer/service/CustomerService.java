/** 
 * @author:pragya
  
 */
package com.cg.ofd.customer.service;

import java.util.List;

import com.cg.ofd.customer.bean.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public List<Customer> findAllCustomer();

	public Customer findById(int customerId);

	public Boolean deleteById(int customerId);

	public void delete();

}
