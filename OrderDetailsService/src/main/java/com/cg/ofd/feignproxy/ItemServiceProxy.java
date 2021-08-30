package com.cg.ofd.feignproxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.ofd.bean.Items;

import io.swagger.annotations.ApiOperation;


@FeignClient(name = "Restaurant-Microservice")
public interface ItemServiceProxy {
	
	@GetMapping("/items/findOneItem/{itemId}")
	public Items findOneItem(@PathVariable int itemId);
	
	@GetMapping("/items/findItemsByName/{itemName}")
	public List<Items> findItemsByName(@PathVariable String itemName);
	
	@PutMapping("/items/updateItem")
	public Items updateItems(@Valid @RequestBody Items items);
	
	@GetMapping("/items/findItemByItemId/{itemId}")
	public List<Items> findItemByItemId(@PathVariable int itemId);
	
}
