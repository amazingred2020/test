package com.senlainc.service;

import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Product;

public interface ProductService {

    Product addProduct(SaveProductRequest request);
    void buyProduct(Long productId, Long buyerId);
}
