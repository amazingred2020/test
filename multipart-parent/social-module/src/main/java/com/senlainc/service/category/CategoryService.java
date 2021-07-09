package com.senlainc.service.category;

import com.senlainc.entity.Category;

public interface CategoryService {

    Category findCategoryById(Long id);
    void saveCategory(Category category);
}
