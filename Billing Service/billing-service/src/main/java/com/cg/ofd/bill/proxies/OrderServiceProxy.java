package com.cg.ofd.bill.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.ofd.bill.entities.OrderDetails;

@FeignClient(name = "Order-microservice")
public interface OrderServiceProxy {
	
	@GetMapping("/order/findOrderByOrderId/{orderId}")
	public OrderDetails findOrdersByOrderId(@PathVariable int orderId) ;
	
	@GetMapping("/order/findOrderByCust/{customerId}")
	public List<OrderDetails> findOrdersByCustomer(@PathVariable int customerId);

}
