package com.cg.ofd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.bean.Customer;
import com.cg.ofd.bean.FoodCart;
import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.OrderDetails;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.exception.OrderNotFoundException;
import com.cg.ofd.service.FoodCartServiceImpl;
import com.cg.ofd.service.FoodCartServiceInterface;
import com.cg.ofd.service.OrderServiceImpl;
import com.cg.ofd.service.OrderServiceInterface;

import io.swagger.annotations.Api;


@Api(value = "OrderController", description = "REST Apis related to Order Entity!!!!")

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderServiceInterface service;

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	FoodCartServiceInterface foodCartservice;

	@PostMapping("/addOrder/{cartId}")
	public OrderDetails addOrder(@RequestBody OrderDetails order, @PathVariable int cartId) {
		logger.info("Inside addOrder() method of OrderController");
		if (order.getOrderDate() == null && order.getOrderStatus() == null) {
			throw new OrderNotFoundException("Can not add order details: Please add order details");
		} else {
			FoodCart cart = foodCartservice.getCartById(cartId);
			order.setFoodCart(cart);
			return this.service.addOrder(order);
		}

	}

	@PutMapping("/updateOrder")
	public OrderDetails updateOrder(@RequestBody OrderDetails order) {
		logger.info("Inside updateOrder() method of OrderController");
		OrderDetails orderDetails = this.service.findOrder(order.getOrderId());
		if (orderDetails == null) {
			throw new OrderNotFoundException("Order with " + order.getOrderId() + " is not not present");
		} else if (order.getOrderStatus() == "Delivered") {
			throw new OrderNotFoundException("You cannot update order irs delivered");
		} else {
			
			return this.service.updateOrder(order);
		}
	}

	@GetMapping("/viewOrder")
	public List<OrderDetails> viewOrder() {
		logger.info("Inside viewOrder() method of OrderController");
		List<OrderDetails> orderDetails = this.service.viewOrder();
		if (orderDetails.isEmpty()) {
			throw new OrderNotFoundException("Order not found");
		} else {
			return orderDetails;
		}
	}
	

	/*
	 * @GetMapping("/viewAllOrdersByRes") public List<OrderDetails>
	 * viewAllOrdersByRes(@PathVariable int restaurantId) {
	 * logger.info("Inside viewAllOrders(res) method of OrderController");
	 * List<OrderDetails> orderDetails =
	 * service.viewAllOrdersByRestaurant(restaurantId); if (orderDetails.isEmpty())
	 * { throw new OrderNotFoundException("Order details of restaurant not found");
	 * } else { return orderDetails; }
	 * 
	 * }
	 */


	@GetMapping("/findOrderByCust/{customerId}")
	public List<OrderDetails> findOrdersByCustomer(@PathVariable int customerId) {
		logger.info("Inside findOrdersByCustomer() method of OrderController");
		List<OrderDetails> orderDetails=service.viewAllOrdersByCustomer(customerId);;
		if(orderDetails.isEmpty()) {
			throw new OrderNotFoundException("Order with customer id "+customerId+" is not present");
		}
		else
		{
			return orderDetails;
		}
		
		
	}
	
	@GetMapping("/findOrderByOrderId/{orderId}")
	public OrderDetails findOrdersByOrderId(@PathVariable int orderId) {
		logger.info("Inside findOrdersByCustomer() method of OrderController");
		OrderDetails orderDetails=service.findOrder(orderId);
		if(orderDetails==null) {
			throw new OrderNotFoundException("Order with customer id "+orderId+" is not present");
		}
		else
		{
			return orderDetails;
		}
		
		
	}

	@RequestMapping(value = "/deleteOrder/{orderId}", method = RequestMethod.DELETE)
	public void removeOrder(@PathVariable Integer orderId) {
		logger.info("Inside removeOrder(orderId) method of OrderController");
		OrderDetails orderDetails = this.service.findOrder(orderId);
		if (orderDetails == null)
			throw new OrderNotFoundException("Order with order Id: " + orderId + " does not exist!!");
		else {
			this.service.removeOrder(orderId);
			System.out.println("Order with Order Id: " + orderId + " removed succesfully from the database!");
		}
	}

	// Implementation for cartService

}
