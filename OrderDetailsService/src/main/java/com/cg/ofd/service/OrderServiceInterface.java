package com.cg.ofd.service;

import java.util.List;
import java.util.Optional;

import com.cg.ofd.bean.Customer;
import com.cg.ofd.bean.OrderDetails;
import com.cg.ofd.bean.Restaurant;

public interface OrderServiceInterface {
	public OrderDetails addOrder(OrderDetails order);
	public OrderDetails updateOrder(OrderDetails order);
	public boolean removeOrder(int order);
	public List<OrderDetails> viewOrder();
	//public List<OrderDetails> viewAllOrdersByRestaurant(int restaurantId);
	public List<OrderDetails> viewAllOrdersByCustomer(int customerId);
	public OrderDetails findOrder(Integer orderId);
}
