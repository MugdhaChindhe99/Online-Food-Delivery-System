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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.bean.Customer;
import com.cg.ofd.bean.FoodCart;
import com.cg.ofd.bean.Items;
import com.cg.ofd.exception.OrderNotFoundException;
import com.cg.ofd.feignproxy.CustomerServiceProxy;
import com.cg.ofd.feignproxy.ItemServiceProxy;
import com.cg.ofd.service.FoodCartServiceInterface;

import io.swagger.annotations.Api;

@Api(value = "FoodCartController", description = "REST Apis related to FoodCart Entity!!!!")

@RestController
@RequestMapping("/foodCart")
//@RibbonClient(name = "Order-microservice")
public class FoodCartController {

	@Autowired
	FoodCartServiceInterface foodCartservice;

	@Autowired
	CustomerServiceProxy cProxy;

	@Autowired
	ItemServiceProxy iProxy;

	private static final Logger logger = LoggerFactory.getLogger(FoodCartController.class);

//	@PostMapping("/addItemsToCart/{customerId}/{itemName}")
//	public void addItemToCart(@RequestBody FoodCart cart, @PathVariable int customerId, @PathVariable String itemName) {
//		logger.info("Inside addItemToCart() method of FoodCartController");
//
//		Customer cust = this.cProxy.getCustomerById(customerId);
//		List<Items> itList = this.iProxy.findItemsByName(itemName);
//
//		if (cust == null || itList.isEmpty() || cart.getItemQuantity()==0) {
//			throw new OrderNotFoundException("Customer with customerId " + customerId + "is not available or item with "
//					+ itemName + " is not available");
//		} else {
//
//			cart.setCustomer(cust);
//			// System.out.println(cart);
//			cart.setItemList(itList);
//
//			for (Items items : itList) {
//				if (items.getItemName().equals(itemName)) {
//					int x = items.getQuantity() - cart.getItemQuantity();
//					items.setQuantity(x);
//					System.out.println(x);
//					this.iProxy.updateItems(items);
//					// itList.set(1, items);
//				}
//
//			}
//			// System.out.println(cart);
//			this.foodCartservice.addItemToCart(cart);
//		}
//
//	}
	
	@PostMapping("/createCart/{customerId}")
	public FoodCart createCart(@PathVariable int customerId) {
		return this.foodCartservice.createCart(customerId);
	
	}
	@PostMapping("/addItemsToCart/{cartId}/{itemId}/{itemQuantity}")
	public void addItemToCart(@PathVariable int cartId,@PathVariable int itemId ,@PathVariable int itemQuantity ) {
		logger.info("Inside addItemToCart() method of FoodCartController");
		this.foodCartservice.addItemToCart( cartId,itemId,itemQuantity);
	}
	
	@PutMapping("/updateCart/{customerId}/{itemName}")
	public void updateCart(@RequestBody FoodCart cart, @PathVariable int customerId, @PathVariable String itemName) {
		logger.info("Inside updateCart() method of FoodCartController");

		//FoodCart fc = this.foodCartservice.getCartById(cartId);
		Customer cust = this.cProxy.getCustomerById(customerId);
		List<Items> itList = this.iProxy.findItemsByName(itemName);

		if (cust == null || itList.isEmpty() || cart.getItemQuantity()==0 ) {
			throw new OrderNotFoundException("Customer with customerId " + customerId + "is not available or item with "
					+ itemName + " is not available");
		} else {

			cart.setCustomer(cust);
			// System.out.println(cart);
			cart.setItemList(itList);

			for (Items items : itList) {
				if (items.getItemName().equals(itemName)) {
					int x = items.getQuantity() - cart.getItemQuantity();
					items.setQuantity(x);
					System.out.println(x);
					this.iProxy.updateItems(items);
					// itList.set(1, items);
				}

			}
			// System.out.println(cart);
			this.foodCartservice.updateCart(cart);
		}

	}

	@DeleteMapping("/deleteCartByid/{cartId}")
	public void clearCart(@PathVariable Integer cartId) {
		logger.info("Inside clearCart(cartId) method of FoodCartController");
		FoodCart cartDetails = this.foodCartservice.findCart(cartId);
		if (cartDetails == null)
			throw new OrderNotFoundException("Cart with cart Id: " + cartId + " does not exist!!");
		else {
			this.foodCartservice.clearCart(cartId);
			System.out.println("Order with Order Id: " + cartId + " removed succesfully from the database!");
		}
	}

	@DeleteMapping("/deleteItemFromCart/{cartId}/{itemId}")
	public void deleteItem(@PathVariable int cartId, @PathVariable int itemId) {
		logger.info("Inside deleteCartByItemId(cartId,itemId) method of FoodCartController");
		FoodCart cart = foodCartservice.getCartById(cartId);
		List<Items> itList = cart.getItemList();
		for (Items item : itList) {
			if (item.getItemId() == itemId) {
				foodCartservice.removeItem(cartId);
			}
		}
	}

	@GetMapping("/viewCart")
	public List<FoodCart> viewCart() {
		logger.info("Inside viewCart() method of FoodCartController");
		List<FoodCart> cartDetails = this.foodCartservice.viewCart();
		if (cartDetails.isEmpty()) {
			throw new OrderNotFoundException("Cart not found");
		} else {
			return cartDetails;
		}
	}

	@GetMapping("/viewCart/{cartId}")
	public FoodCart viewCartByCartId(@PathVariable int cartId) {
		logger.info("Inside ViewCartById(cartId) method of FoodCartController");
		FoodCart fc = this.foodCartservice.getCartById(cartId);
		if (fc == null) {
			throw new OrderNotFoundException("ViewCart by CartId" + cartId + " not found");
		} else
			return fc;
	}

	/*
	 * @GetMapping("/viewCartByCustId/{customerId}") public List<FoodCart>
	 * viewCartByCust(@PathVariable int customerId) {
	 * logger.info("Inside findNearByRestaurant() method of RestaurantController");
	 * Customer cust = this.cProxy.getCustomerById(customerId); List<FoodCart> fc =
	 * this.foodCartservice.viewCartByCustId(customerId); if (fc.isEmpty()) { throw
	 * new OrderNotFoundException("restaurant in area" + customerId + " not found");
	 * } else return fc; }
	 */

	@PutMapping("/increaseQuantity/{cartId}/{itemId}/{quantity}")
	public FoodCart increaseQuantity(@PathVariable int cartId, @PathVariable int itemId, @PathVariable int quantity) {
		logger.info("Inside increaseQuantity(cartId,itemId,quantity) method of FoodCartController");
		FoodCart cart = foodCartservice.getCartById(cartId);
		List<Items> itList = cart.getItemList();
		for (Items item : itList) {
			if (item.getItemId() == itemId) {
				int temp = cart.getItemQuantity() + quantity;
				cart.setItemQuantity(temp);
				int x = item.getQuantity() - quantity;
				item.setQuantity(x);
				System.out.println(x);
				this.iProxy.updateItems(item);
			}
		}
		cart.setItemList(itList);
		foodCartservice.increaseQuantity(cart);
		return cart;
	}

	@PutMapping("/decreaseQuantity/{cartId}/{itemId}/{quantity}")
	public FoodCart decreaseQuantity(@PathVariable int cartId, @PathVariable int itemId, @PathVariable int quantity) {
		logger.info("Inside decreaseQuantity(cartId,itemId,quantity) method of FoodCartController");
		FoodCart cart = foodCartservice.getCartById(cartId);
		List<Items> itList = cart.getItemList();
		for (Items item : itList) {
			if (item.getItemId() == itemId) {
				int temp = cart.getItemQuantity() - quantity;
				cart.setItemQuantity(temp);
				int x = item.getQuantity() + quantity;
				item.setQuantity(x);
				System.out.println(x);
				this.iProxy.updateItems(item);
			}
		}
		cart.setItemList(itList);
		foodCartservice.reduceQuantity(cart);
		return cart;
	}

}
