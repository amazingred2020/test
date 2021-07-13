package com.senlainc.app.service;

import com.senlainc.container.annotation.InjectComponent;
import com.senlainc.container.factory.ComponentFactory;
import com.senlainc.app.dao.CategoryDao;
import com.senlainc.app.entity.Category;

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