package com.senlainc.dao;

import com.senlainc.entity.ProductChecker;

import java.util.List;
import java.util.Optional;

public interface CheckerDao {
    void save(ProductChecker productChecker);

    Optional<List<ProductChecker>> getAllPendingProducts();

    ProductChecker getById(Long id);
}
