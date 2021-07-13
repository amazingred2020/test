package com.senlainc.app.controller;

import com.senlainc.container.annotation.InjectComponent;
import com.senlainc.container.factory.ComponentFactory;
import com.senlainc.app.entity.Category;
import com.senlainc.app.service.CategoryService;

public class CategoryController {

	@InjectComponent
	private CategoryService categoryService;

	public CategoryController(){
	    this.categoryService = ComponentFactory.getInstance().getComponent(CategoryService.class);
    }

    public void addCategory(Category category){
    	Category saveCategory = categoryService.saveCategory(category);
        System.out.println(String.format("Категория %s успешно сохранена", saveCategory.toString())); 
    }

    public void findCategoryById(Long id){
    	Category category = categoryService.findCategoryById(id);
    	System.out.println(String.format("Найденная категория по id = %d : %s", id, category.toString())); 
    }
}