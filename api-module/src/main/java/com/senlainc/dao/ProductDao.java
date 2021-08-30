package com.senlainc.dao;

import com.senlainc.entity.Product;

import java.util.List;

public interface ProductDao {

    Product save(Product product);
    void remove(Long id);
    Product findById(Long id);
    Product findByName(String name);

    List<Product> getPaginatedUserList(int page, int size);

    List<Product> getAllProducts();
}
