package com.senlainc.app.service;
import com.senlainc.app.entity.Category;

public interface CategoryService {

    Category findCategoryById(Long id);
    Category saveCategory(Category category);
}