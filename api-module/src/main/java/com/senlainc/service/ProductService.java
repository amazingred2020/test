package com.senlainc.service;

import com.senlainc.dto.product.AddProductRequest;
import com.senlainc.entity.Product;

public interface ProductService {

    Product saveProduct(Product product);
    void deleteProduct(Long id);
    Product findProductById(Long id);
    Product addProduct(AddProductRequest request);
    void buyProduct(Long productId, Long buyerId);
}
