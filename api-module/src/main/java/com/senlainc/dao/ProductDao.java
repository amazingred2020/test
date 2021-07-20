package com.senlainc.dao;

import com.senlainc.entity.Product;

public interface ProductDao {

    Product save(Product product);
    void remove(Long id);
    Product findById(Long id);
}
