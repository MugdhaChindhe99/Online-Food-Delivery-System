package com.cg.ofd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.ofd.bean.Category;


public interface CategoryService {

	public Category addCategory(Category cat);
	public Category updateCategory(Category cat);
	public void removeCategory(int categoryId);
	public boolean deleteCategory(int categoryId);	
	public Optional<Category> findCategory(int categoryId);
	public Category findOneCategory(int categoryId);
	public List<Category> findAllCategory();
	
	
	
}
