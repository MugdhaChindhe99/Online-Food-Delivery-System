package com.cg.ofd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ofd.bean.Customer;
import com.cg.ofd.bean.FoodCart;
import com.cg.ofd.bean.OrderDetails;
import com.cg.ofd.bean.Restaurant;

@Repository
public interface OrderDao extends JpaRepository<OrderDetails, Integer> {
	 
	 //public List<OrderDetails> viewAllOrdersByRestaurant(Restaurant restaurant);
	 
	 
	// public List<OrderDetails> viewAllOrdersByCustomer(FoodCart customer);
	

}
