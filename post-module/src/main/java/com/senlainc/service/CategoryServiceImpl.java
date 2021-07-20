package com.senlainc.service;

import com.senlainc.dao.CategoryDao;
import com.senlainc.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category saveCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryDao.remove(id);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryDao.findById(id);
    }
}