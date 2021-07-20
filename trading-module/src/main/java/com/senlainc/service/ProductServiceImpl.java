package com.senlainc.service;

import com.senlainc.dao.ProductDao;
import com.senlainc.entity.Product;
import com.senlainc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product saveProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.remove(id);
    }

    @Override
    public Product findProductById(Long id) {
        return productDao.findById(id);
    }
}
