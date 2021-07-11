package com.senlainc.service.category;

import com.senlainc.dao.CategoryDao;
import com.senlainc.entity.Category;

public class CategoryServiceImpl implements CategoryService{

    private CategoryDao cd;

    public CategoryServiceImpl(){
        this.cd = new CategoryDao();
    }

	public Category findCategoryById(Long id) {
		return cd.findById(id);
	}

	public void saveCategory(Category category) {
		cd.save(category);
	}

}
