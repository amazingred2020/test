package com.senlainc.controller;

import com.senlainc.entity.Category;
import com.senlainc.service.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	Logger logger = LogManager.getLogger();

    public void addCategory(Category category){
    	Category saveCategory = categoryService.saveCategory(category);
        logger.info(String.format("Категория %s успешно сохранена", saveCategory.toString()));
    }

    public void findCategoryById(Long id){
    	Category category = categoryService.findCategoryById(id);
    	logger.info(String.format("Найденная категория по id = %d : %s", id, category.toString()));
    }
}