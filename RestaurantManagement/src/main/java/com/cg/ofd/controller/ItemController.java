package com.cg.ofd.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.bean.Category;
import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.exception.EntityNotFoundException;
import com.cg.ofd.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("http://localhost:4200")
@Api(value = "ItemController", description = "REST Apis related to Item Entity!!!!")
@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemservice;
	
	private static final Logger logger=LoggerFactory.getLogger(CategoryController.class);
	
	@PostMapping("/addItem")
	@ApiOperation(value = "Add Item Details", response = Iterable.class)
	public Items addItems(@Valid @RequestBody Items items){
		logger.info("Inside addItem() method of ItemController");
		if(items.getItemName()==null) {
			throw new EntityNotFoundException("Items details not found");
		}
		else
		return itemservice.addItem(items);
	}
	
	@PutMapping("/updateItem")
	@ApiOperation(value = " Update Items Details", response = Iterable.class)
	public Items updateItems(@Valid @RequestBody Items items){
		logger.info("Inside updateItem() method of ItemController");
		if(items==null) {
			throw new EntityNotFoundException("Items details not found");
		}
		else
		return itemservice.updateItem(items);
	}
	
	@DeleteMapping("/deleteItem/{itemId}")
	@ApiOperation(value = "Delete Item Details", response = Iterable.class)
	public void deleteItems(@PathVariable int itemId){
		logger.info("Inside deleteItem() method of ItemController");
		 Optional<Items> items= this.itemservice.findItem(itemId);
		 if(!items.isPresent()) {
			throw new EntityNotFoundException("Items id"+ itemId +"not found");
		}
		else {
			this.itemservice.removeItem(itemId);
			System.out.println("Items details of id "+ itemId +" is successfully deleted");
		}
        
	}

//	@GetMapping("/findOneItem/{itemId}")
//	@ApiOperation(value = "Find A Item ", response = Iterable.class)
//	public Optional<Items> findOneItem(@PathVariable int itemId){
//		logger.info("Inside findOneItem() method of ItemController");
//       Optional<Items> item= this.itemservice.findOneItem(itemId);
//		if(item.equals(null)) {
//			throw new EntityNotFoundException("Items id"+ itemId +"not found");
//		}
//		else
//			return item;
//	}
	
	@GetMapping("/findOneItem/{itemId}")
	@ApiOperation(value = "Find A Item ", response = Iterable.class)
	public Items findOneItem(@PathVariable int itemId){
		logger.info("Inside findOneItem() method of ItemController");
		return this.itemservice.findItem(itemId).orElseThrow(()->new EntityNotFoundException("Items id"+ itemId +"not found"));
	}
	
	@GetMapping("/findItemByItemId/{itemId}")
	@ApiOperation(value = "Find A Item ", response = Iterable.class)
	public List<Items> findItemByItemId(@PathVariable int itemId){
		logger.info("Inside findOneItem() method of ItemController");
		return this.itemservice.findItembyItemId(itemId);
	}
	
	@GetMapping("/findItems")
	@ApiOperation(value = "Find All Items ", response = Iterable.class)
	public List<Items> findAllItems(){
		logger.info("Inside findAllItem() method of ItemController");
       List<Items> item= this.itemservice.findAllItems();
		if(item.isEmpty()) {
			throw new EntityNotFoundException("Items not found");
		}
		else
			return item;
	}
	
	@GetMapping("/findItemsByName/{itemName}")
	@ApiOperation(value = "Find Items by Name", response = Iterable.class)
	public List<Items> findItemsByName(@PathVariable String itemName){
		logger.info("Inside findItemsByName() method of ItemController");
		 List<Items> item= this.itemservice.findAllItemByName(itemName);
		if(item.isEmpty()) {
			throw new EntityNotFoundException("Item Name"+ itemName +"not found");
		}
		else 
			return item;
	}
	
	@GetMapping("/findAllItemsByCategory")
	@ApiOperation(value = "FInd All Items by category", response = Iterable.class)
	public List<Items> findAllItems(@RequestBody Category c){
		logger.info("Inside findAllItems() method of ItemController");
		 List<Items> item= this.itemservice.findAllItems(c);
			if(item.isEmpty()) {
				throw new EntityNotFoundException("Items with category id"+ c.getCategoryId() +"not found");
			}
			else 
				return item;
	}
	
	@GetMapping("/findAllItemsByRestaurant")
	@ApiOperation(value = "find all items by restaurant", response = Iterable.class)
	public List<Items> findAllItems(@RequestBody Restaurant r){
		logger.info("Inside findAllItems() method of ItemController");
		 List<Items> item=this.itemservice.findAllItems(r);
			if(item.isEmpty()) {
				throw new EntityNotFoundException("Items with restaurant id"+ r.getRestaurantId() +"not found");
			}
			else 
				return item;
	}
	
	
	
}
