package com.senlainc.controller;

import com.senlainc.entity.Category;
import com.senlainc.service.CategoryService;
import com.senlainc.annotation.InjectComponent;
import com.senlainc.factory.ComponentFactory;

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