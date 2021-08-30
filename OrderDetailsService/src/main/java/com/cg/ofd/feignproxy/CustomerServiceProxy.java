package com.cg.ofd.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.ofd.bean.Customer;


@FeignClient(name = "Customer-Microservice")
public interface CustomerServiceProxy {
	@GetMapping("/customer/search/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId);
	
	@PutMapping("/customer/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer);
}
