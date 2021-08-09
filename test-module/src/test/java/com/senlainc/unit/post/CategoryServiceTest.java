package com.senlainc.unit.post;

import com.senlainc.dao.CategoryDao;
import com.senlainc.entity.Category;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.CategoryService;
import com.senlainc.testconfig.TestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ContextConfiguration(classes = {JpaConfiguration.class, TestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void testDeleteCategory(){
        Long id = 1l;
        categoryService.deleteCategory(id);
        Category category = categoryService.findCategoryById(1l);

        Assert.assertNull(category);
    }

    @Test
    public void testFindCategoryById(){
        Category category = categoryService.findCategoryById(1l);
        Assert.assertFalse(category.getName().length() == 0);
    }

    @Test
    public void testCreateCategory(){
        categoryService.createCategory("category name", null);
        Category category = categoryDao.findByName("category name");

        Assert.assertNull(category.getParent());
    }
}
