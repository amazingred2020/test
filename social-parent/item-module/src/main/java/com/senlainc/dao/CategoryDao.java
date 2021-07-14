package com.senlainc.dao;

import com.senlainc.entity.Category;

public interface CategoryDao {

	Category save(Category category);
	Category findById(Long id);
}
