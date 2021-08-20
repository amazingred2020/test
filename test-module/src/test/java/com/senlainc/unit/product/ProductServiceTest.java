package com.senlainc.unit.product;

import com.senlainc.dao.ProductDao;
import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Product;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.ProductService;
import com.senlainc.TestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@ContextConfiguration(classes = {JpaConfiguration.class, TestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDao productDao;

    @Test
    public void testAddProduct() {
        SaveProductRequest request = new SaveProductRequest();
        request.setName("product name");
        request.setDescription("description");
        request.setPrice(new BigDecimal("2400"));
        request.setUserId(2l);
        productService.addProduct(request);
        Product product = productDao.findByName("product name");

        Assert.assertEquals(Long.valueOf(2l), product.getUser().getId());
    }
    @Test(expected = NoSuchElementException.class)
    public void buyProduct() {
        productService.buyProduct(2l,1l);
        Product product = productDao.findById(2l);
    }
}
