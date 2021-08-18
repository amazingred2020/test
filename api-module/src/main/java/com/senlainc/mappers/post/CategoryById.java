package com.senlainc.mappers.post;

import com.senlainc.dao.CategoryDao;
import com.senlainc.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryById {

    @Autowired
    private CategoryDao categoryDao;

    public Category fromIdToCategory(Long id){
        return categoryDao.findById(id);
    }
}