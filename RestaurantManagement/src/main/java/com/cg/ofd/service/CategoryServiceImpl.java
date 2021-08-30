package com.cg.ofd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofd.bean.Category;
import com.cg.ofd.dao.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository catrepo;
	
	
	@Override
	public Category addCategory(Category cat) {
		return this.catrepo.save(cat);
	}

	@Override
	public Category updateCategory(Category cat) {
		return this.catrepo.save(cat);
	}

	@Override
	public void removeCategory(int categoryId) {
		this.catrepo.deleteById(categoryId);

	}

	@Override
	public Optional<Category> findCategory(int categoryId) {
		return catrepo.findById(categoryId);
	
	}
	
	@Override
	public Category findOneCategory(int categoryId) {
		return catrepo.findAll().stream().filter(id->id.getCategoryId() == categoryId).findAny().get();
	}

	@Override
	public List<Category> findAllCategory() {
		return catrepo.findAll();
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		this.catrepo.deleteById(categoryId); 
		return true;
	}

	

}
