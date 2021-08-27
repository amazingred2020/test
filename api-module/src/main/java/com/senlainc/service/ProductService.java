package com.senlainc.service;

import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(SaveProductRequest request);
    void buyProduct(Long productId, Long buyerId);

    List<Product> getPaginatedUserList(int page, int size);

    void saveProduct(Product product);
}
