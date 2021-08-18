package com.senlainc.service;

import com.senlainc.entity.Category;

public interface CategoryService {

    void deleteCategory(Long id);
    Category findCategoryById(Long id);
    void createCategory(String name, Long parentId);
}