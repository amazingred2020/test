package com.senlainc.controller;

import com.senlainc.entity.Category;
import com.senlainc.service.category.CategoryService;

public class CategoryController {

    private CategoryService ms;

    public CategoryController(CategoryService service){
        ms = service;
    }

    public String addCategory(Category category){
        ms.saveCategory(category);
        return "Категория с именем \""+ category.getName() + "\" успешно сохранена!";
    }

    public Category findCategoryById(Long id){
        return ms.findCategoryById(id);
    }
}
