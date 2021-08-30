package com.cg.ofd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofd.bean.Category;
import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.Restaurant;

@Repository
public interface ItemRepository extends JpaRepository<Items, Integer> {

	public List<Items> findByItemName(String itemName);
	public List<Items> findAllItemsByCategory(Category c);
	public List<Items> findAllItemsByRestaurant(Restaurant r);
	public List<Items> findByItemId(int itemId);
	
}
