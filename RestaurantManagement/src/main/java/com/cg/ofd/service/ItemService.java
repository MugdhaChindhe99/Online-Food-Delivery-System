package com.cg.ofd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.ofd.bean.Category;
import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.Restaurant;


public interface ItemService {

	public Items addItem(Items item);
	public Items updateItem(Items item);
	public void removeItem(int itemId);
	public Optional<Items> findItem(int itemId);
	public Items findOneItem(int itemId);
	public List<Items> findItembyItemId(int itemId);
	public List<Items> findAllItems();
	
	public List<Items> findAllItemByName(String itemName);
	public List<Items> findAllItems(Category c);
	public List<Items> findAllItems(Restaurant r);
	
	
	
}
