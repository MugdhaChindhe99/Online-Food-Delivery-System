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
import com.cg.ofd.exception.EntityNotFoundException;
import com.cg.ofd.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("http://localhost:4200")
//Run Swagger http://localhost:9300/swagger-ui.html
@Api(value = "CategoryController", description = "REST Apis related to Category Entity!!!!")
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService catservice;
	
	private static final Logger logger=LoggerFactory.getLogger(CategoryController.class);
	
	@PostMapping("/addCategory")
	@ApiOperation(value = "Add Category Details", response = Iterable.class)
	public Category addCategory( @Valid @RequestBody Category cat){
		logger.info("Inside addCategory() method of CategoryController");
		if(cat.getCategoryName()==null) {
			throw new EntityNotFoundException("Category details not found");
		}
		else
		return catservice.addCategory(cat);
	}
	
	@PutMapping("/updateCategory")
	@ApiOperation(value = "Update Category Details", response = Iterable.class)
	public Category updateCategory(@Valid @RequestBody Category cat){
		logger.info("Inside updateCategory() method of CategoryController");
		if(cat==null) {
			throw new EntityNotFoundException("Category details not found");
		}
		else
		return catservice.updateCategory(cat);
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	@ApiOperation(value = "Delete Category ", response = Iterable.class)
	public void removeCategory(@PathVariable int categoryId){
		logger.info("Inside deleteCategory() method of CategoryController");
		 Optional<Category> cat= this.catservice.findCategory(categoryId);
		if(!cat.isPresent()) {
			throw new EntityNotFoundException("Category id"+ categoryId +"not found");
		}
		else {
        this.catservice.removeCategory(categoryId);
		System.out.println("Category details of id "+ categoryId +" is successfully deleted");
		}
	}
	
	@DeleteMapping("/removeCategory1/{categoryId}")
	@ApiOperation(value = "Delete Category ", response = Iterable.class)
	public boolean deleteCategory(@PathVariable int categoryId){
		logger.info("Inside removeCategory() method of CategoryController");
		 Optional<Category> cat= this.catservice.findCategory(categoryId);
		if(!cat.isPresent()) {
			throw new EntityNotFoundException("Category id"+ categoryId +"not found");
		}
		else {
        this.catservice.deleteCategory(categoryId);
		System.out.println("Category details of id "+ categoryId +" is successfully deleted");
		return true;
		}
	}

//	@GetMapping("/findOneCategory/{categoryId}")
//	@ApiOperation(value = "Find A Category", response = Iterable.class)
//	public Optional<Category> findOneCategory(@PathVariable int categoryId){
//		logger.info("Inside findOneCategory() method of CategoryController");
//		Optional<Category> cat= this.catservice.findOneCategory(categoryId);
//		if(cat.equals(null)) {
//			throw new EntityNotFoundException("Category id"+ categoryId +"not found");
//		}
//		else
//       return cat;
//	}
	
	@GetMapping("/findOneCategory/{categoryId}")
	@ApiOperation(value = "Find A Category", response = Iterable.class)
	public Category findOneCategory(@PathVariable int categoryId){
		logger.info("Inside findOneCategory() method of CategoryController");
		return this.catservice.findOneCategory(categoryId);
		//return this.catservice.findCategory(categoryId).orElseThrow(()->new EntityNotFoundException("Category id"+ categoryId +"not found"));
	}
	
	@GetMapping("/findCategory")
	@ApiOperation(value = "Find All Category ", response = Iterable.class)
	public List<Category> findAllCategory(){
		logger.info("Inside findAllCategory() method of CategoryController");
		List<Category> cat= this.catservice.findAllCategory();
		if(cat.isEmpty()) {
			throw new EntityNotFoundException("Category details not found");
		}
		else
       return cat;
	}
	

}
