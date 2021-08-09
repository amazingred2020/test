package com.senlainc.service;

import com.senlainc.dto.product.AddProductRequest;
import com.senlainc.entity.Product;

public interface ProductService {

    Product addProduct(AddProductRequest request);
    void buyProduct(Long productId, Long buyerId);
}
