package com.senlainc.app.dao;

import com.senlainc.app.entity.Category;

public interface CategoryDao {

	Category save(Category category);
	Category findById(Long id);
}
