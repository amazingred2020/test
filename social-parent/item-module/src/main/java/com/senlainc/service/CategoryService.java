package com.senlainc.service;
import com.senlainc.entity.Category;

public interface CategoryService {

    Category findCategoryById(Long id);
    Category saveCategory(Category category);
}