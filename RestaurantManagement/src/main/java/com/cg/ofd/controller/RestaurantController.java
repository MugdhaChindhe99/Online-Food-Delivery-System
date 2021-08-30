package com.cg.ofd.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.exception.EntityNotFoundException;
import com.cg.ofd.service.RestaurantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("http://localhost:4200")
@Api(value = "RestaurantController", description = "REST Apis related to Restaurant Entity!!!!")
@RestController
@RibbonClient(name="Restaurant-Microservice")
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restservice;
	
	private static final Logger logger=LoggerFactory.getLogger(RestaurantController.class);
	
	@PostMapping("/addRestaurant")
	@ApiOperation(value = "Add Restaurant Details", response = Iterable.class)
	public Restaurant addRestaurant(@Valid @RequestBody Restaurant restro){
		logger.info("Inside addRestaurant() method of RestaurantController");
		if(restro.getRestaurantName()==null) {
			throw new EntityNotFoundException("Restaurant details not found");
		}
		else
		return restservice.addRestaurant(restro);
	}
	
	@PutMapping("/updateRestaurant")
	@ApiOperation(value = "Update Restaurant Details", response = Iterable.class)
	public Restaurant updateRestaurant(@Valid @RequestBody Restaurant restro){
		logger.info("Inside updateRestaurant() method of RestaurantController");
		if(restro==null) {
			throw new EntityNotFoundException("Restaurant details not found");
		}
		else
		return restservice.updateRestaurant(restro);
	}
	
	@DeleteMapping("/deleteRestaurant/{restaurantId}")
	@ApiOperation(value = "Delete Restaurant Details", response = Iterable.class)
	public void deleteRestaurant(@PathVariable int restaurantId){
		logger.info("Inside deleteRestaurant() method of RestaurantController");
		 Optional<Restaurant> restro= this.restservice.findRestaurant(restaurantId);
		if(!restro.isPresent()) {
			throw new EntityNotFoundException("restaurant id"+ restaurantId +"not found");
		}
		else {
			 this.restservice.removeRestaurant(restaurantId);
			System.out.println("restaurant details of id "+ restaurantId +" is successfully deleted");
		}
	}

//	@GetMapping("/findOneRestaurant/{restaurantId}")
//	@ApiOperation(value = "Find A Restaurant ", response = Iterable.class)
//	public Optional<Restaurant> findOneRestaurant(@PathVariable int restaurantId){
//		logger.info("Inside findOneRestaurant() method of RestaurantController"); 
//       Optional<Restaurant> restro= this.restservice.findOneRestaurant(restaurantId);
//		if(restro.equals(null)) {
//			throw new EntityNotFoundException("restaurant id"+ restaurantId +"not found");
//		}
//		else
//			return restro;   
//	}
	
	@GetMapping("/findOneRestaurant/{restaurantId}")
	@ApiOperation(value = "Find A Restaurant ", response = Iterable.class)
	public Restaurant findOneRestaurant(@PathVariable int restaurantId){
		logger.info("Inside findOneRestaurant() method of RestaurantController"); 
		return this.restservice.findRestaurant(restaurantId).orElseThrow(()->new EntityNotFoundException("Restaurant id"+ restaurantId +"not found"));
	}
	
	@GetMapping("/findRestaurant")
	@ApiOperation(value = "FInd All Restaurant ", response = Iterable.class)
	public List<Restaurant> findAllRestaurant(){
		logger.info("Inside findALlRestaurant() method of RestaurantController");
		 List<Restaurant> restro=this.restservice.findAllRestaurant();
			if(restro.isEmpty()) {
				throw new EntityNotFoundException("restaurant  not found");
			}
			else
				return restro;
	}
	
	@GetMapping("/findNearByRestaurant/{area}")
	@ApiOperation(value = "Find NearBy Restaurant", response = Iterable.class)
	public List<Restaurant> findNearByRestaurant(@PathVariable String area){
		logger.info("Inside findNearByRestaurant() method of RestaurantController");
		List<Restaurant> restro=this.restservice.findNearByRestaurant(area);
		System.out.println(restro);
		if(restro.isEmpty()) {
			throw new EntityNotFoundException("restaurant in area"+ area +" not found");
		}
		else
			return restro;
	}
	
	@GetMapping("/findRestaurantByItemName/{itemName}")
	public List<Restaurant> findRestaurantByItemName(@PathVariable String itemName){
       return this.restservice.findRestaurantByItemName(itemName);
	}
	
}
