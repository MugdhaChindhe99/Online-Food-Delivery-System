package com.cg.ofd.service;

import java.util.List;


import com.cg.ofd.bean.FoodCart;
import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.OrderDetails;


public interface FoodCartServiceInterface {
	public FoodCart createCart(int customerId);
	public FoodCart addItemToCart(int cartId,int itemId,int itemQuantity);
	public FoodCart updateCart(FoodCart cart);
	public FoodCart increaseQuantity(FoodCart cart);
	public FoodCart reduceQuantity(FoodCart cart);
	public void removeItem(int cartId);
	public boolean clearCart(int cartId);
	public List<Items> getAllItemsByCartIdItemId(int cartId, int itemId);
	public List<FoodCart> viewCart();
	public FoodCart getCartById(Integer cartId);
	public FoodCart getCartByItemId(Integer itemId);
	public FoodCart findCart(Integer cartId);

	
}
