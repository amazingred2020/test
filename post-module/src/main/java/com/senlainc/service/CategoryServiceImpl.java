package com.senlainc.service;

import com.senlainc.dao.CategoryDao;
import com.senlainc.entity.Category;
import com.senlainc.mappers.post.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void deleteCategory(Long id) {
        categoryDao.remove(id);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public void createCategory(String name, Long parentId) {
        Category newCategory = categoryMapper.fromParametersToCategory(name, parentId);
        categoryDao.save(newCategory);
    }

}
