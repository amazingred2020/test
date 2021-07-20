package com.senlainc.service;

import com.senlainc.entity.Category;

public interface CategoryService {

    Category saveCategory(Category category);
    void deleteCategory(Long id);
    Category findCategoryById(Long id);
}
