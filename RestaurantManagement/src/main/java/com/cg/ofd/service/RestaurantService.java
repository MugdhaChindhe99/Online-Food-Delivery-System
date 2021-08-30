package com.cg.ofd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.ofd.bean.Address;
import com.cg.ofd.bean.Restaurant;



public interface RestaurantService {

	public Restaurant addRestaurant(Restaurant restaurant);
	public Restaurant updateRestaurant(Restaurant restaurant);
	public void removeRestaurant(int restaurantId);
	public Optional<Restaurant> findRestaurant(int restaurantId);
	public Restaurant findOneRestaurant(int restaurantId);
	public List<Restaurant> findAllRestaurant();
	
	public List<Restaurant> findNearByRestaurant(String area);	
	public List<Restaurant> findRestaurantByItemName(String itemName);
}
