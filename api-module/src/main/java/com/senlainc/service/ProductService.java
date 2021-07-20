package com.senlainc.service;

import com.senlainc.entity.Product;

public interface ProductService {

    Product saveProduct(Product product);
    void deleteProduct(Long id);
    Product findProductById(Long id);
}
