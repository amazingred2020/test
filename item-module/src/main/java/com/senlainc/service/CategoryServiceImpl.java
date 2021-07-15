package com.senlainc.service;

import com.senlainc.annotation.InjectComponent;
import com.senlainc.factory.ComponentFactory;
import com.senlainc.dao.CategoryDao;
import com.senlainc.entity.Category;

public class CategoryServiceImpl implements CategoryService{

	@InjectComponent
	private CategoryDao categoryDao;

    public CategoryServiceImpl(){
    	this.categoryDao = ComponentFactory.getInstance().getComponent(CategoryDao.class);
    }
	
	@Override
	public Category findCategoryById(Long id) {
		return categoryDao.findById(id);
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryDao.save(category);
	}
}