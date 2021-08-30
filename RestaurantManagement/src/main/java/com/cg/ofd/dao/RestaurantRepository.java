package com.cg.ofd.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ofd.bean.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

	@Query("select r from Restaurant r where address.area =:area")
	public List<Restaurant> findNearByRestaurant(@Param("area") String area);
	
	@Query("select r from Restaurant r left join r.item i where i.itemName =:itemName")
	public List<Restaurant> findRestaurantByItemName(@Param("itemName") String itemName);
	
}
