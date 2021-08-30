package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.ofd.bean.Address;
import com.cg.ofd.bean.Category;
import com.cg.ofd.bean.Customer;
import com.cg.ofd.bean.FoodCart;
import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.OrderDetails;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.service.FoodCartServiceImpl;
import com.cg.ofd.service.FoodCartServiceInterface;
import com.cg.ofd.service.OrderServiceImpl;
import com.cg.ofd.service.OrderServiceInterface;

public class FoodCartTest {

//	@Test
//	public void addFoodCartTest() {
//
//		Address hoteladdress = new Address(101, "Pride", "S10Road", "Shivajinagar", "Pune", "Maharashtra", "India",
//				"412217");
//
//		Address custaddress = new Address(102, "Shashikant", "Lane2", "Swargate", "Pune", "Maharashtra", "India",
//				"412201");
//
//		Category cat = new Category(103, "FastFood");
//
//		List<Restaurant> restro = new ArrayList<>();
//
//		Restaurant r1 = new Restaurant(101, "Sahara", hoteladdress, "Tejaswi", "9011872311");
//
//		restro.add(r1);
//
//		List<Items> items = new ArrayList<>();
//		Items item = new Items(114, "item6", cat, 2, 100, restro);
//		items.add(item);
//
//		Customer cust = new Customer(1, "Tejaswi", "Midgule", "female", "22", "9011872311", "tmidgule98@gmail.com",
//				custaddress);
//
//		FoodCart cart = new FoodCart(12, 2, cust, items);
//
//		FoodCartServiceInterface foodCartService = mock(FoodCartServiceImpl.class);
//		when(foodCartService.addItemToCart(cart)).thenReturn(cart);
//		FoodCart cart1 = foodCartService.addItemToCart(cart);
//		assertEquals(cart, cart1);
//	}
//
//	@Test
//	public void viewCartTest() {
//		Address hoteladdress = new Address(101, "Pride", "S10Road", "Shivajinagar", "Pune", "Maharashtra", "India",
//				"412217");
//
//		Address custaddress = new Address(102, "Shashikant", "Lane2", "Swargate", "Pune", "Maharashtra", "India",
//				"412201");
//
//		Category cat = new Category(103, "FastFood");
//
//		List<Restaurant> restro = new ArrayList<>();
//
//		Restaurant r1 = new Restaurant(101, "Sahara", hoteladdress, "Tejaswi", "9011872311");
//
//		restro.add(r1);
//
//		List<Items> items = new ArrayList<>();
//		Items item = new Items(114, "item6", cat, 2, 100, restro);
//		items.add(item);
//
//		Customer cust = new Customer(1, "Tejaswi", "Midgule", "female", "22", "9011872311", "tmidgule98@gmail.com",
//				custaddress);
//
//		FoodCart cart = new FoodCart(12, 2, cust, items);
//		FoodCartServiceInterface foodCartService = mock(FoodCartServiceImpl.class);
//		when(foodCartService.findCart(12)).thenReturn(cart);
//		FoodCart cart1 = foodCartService.findCart(12);
//		assertEquals(cart, cart1);
//
//	}
//
//	@Test
//	public void removeCart() {
//		Address hoteladdress = new Address(101, "Pride", "S10Road", "Shivajinagar", "Pune", "Maharashtra", "India",
//				"412217");
//
//		Address custaddress = new Address(102, "Shashikant", "Lane2", "Swargate", "Pune", "Maharashtra", "India",
//				"412201");
//
//		Category cat = new Category(103, "FastFood");
//
//		List<Restaurant> restro = new ArrayList<>();
//
//		Restaurant r1 = new Restaurant(101, "Sahara", hoteladdress, "Tejaswi", "9011872311");
//
//		restro.add(r1);
//
//		List<Items> items = new ArrayList<>();
//		Items item = new Items(114, "item6", cat, 2, 100, restro);
//		items.add(item);
//
//		Customer cust = new Customer(1, "Tejaswi", "Midgule", "female", "22", "9011872311", "tmidgule98@gmail.com",
//				custaddress);
//
//		FoodCart cart = new FoodCart(12,2, cust, items);
//		FoodCartServiceInterface foodCartService = mock(FoodCartServiceImpl.class);
//		foodCartService.addItemToCart(cart);
//
//		when(foodCartService.clearCart(12)).thenReturn(Boolean.TRUE);
//		Boolean cartService2 = foodCartService.clearCart(12);
//		assertEquals(Boolean.TRUE, cartService2);
//	}
}
