package com.cg.ofd.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofd.bean.Address;
import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.dao.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restrepo;
	
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		return this.restrepo.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		return this.restrepo.save(restaurant);
	}

	@Override
	public void removeRestaurant(int restaurantId) {
		// this.restrepo.deleteById(restaurantId);
		Restaurant r = restrepo.findAll().stream().filter(id->id.getRestaurantId()==restaurantId).findAny().get();
		if(r!=null) {
			try {
				r.getItem().forEach(item->{item.getRestaurant().remove(r);});
				restrepo.delete(r);
				
			}catch (Exception e) {
                e.printStackTrace();
            }
		}

	}

	@Override
	public Optional<Restaurant> findRestaurant(int restaurantId) {
		return restrepo.findById(restaurantId);
	}
	@Override
	public Restaurant findOneRestaurant(int restaurantId) {
		return restrepo.findAll().stream().filter(id->id.getRestaurantId() == restaurantId).findAny().get();
	}

	@Override
	public List<Restaurant> findAllRestaurant() {
		return restrepo.findAll();
	}

	@Override
	public List<Restaurant> findNearByRestaurant(String area) {
		return this.restrepo.findNearByRestaurant(area);
	}

    
	@Override
	public List<Restaurant> findRestaurantByItemName(String itemName) {
		return this.restrepo.findRestaurantByItemName(itemName);
	}

	
}
