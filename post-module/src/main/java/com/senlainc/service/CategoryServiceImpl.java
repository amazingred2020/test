package com.senlainc.service;

import com.senlainc.dao.CategoryDao;
import com.senlainc.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

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
        Category newCategory = new Category(name);
        if(parentId != null){
            newCategory.setParent(categoryDao.findById(parentId));
        }
        categoryDao.save(newCategory);
    }

}
