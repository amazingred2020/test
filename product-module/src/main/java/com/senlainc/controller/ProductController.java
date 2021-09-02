package com.senlainc.controller;

import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Product;
import com.senlainc.routes.ProductRoutes;
import com.senlainc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(ProductRoutes.PRODUCT)
    public Product addProductForSale(@RequestBody @Validated SaveProductRequest request){
        return productService.addProduct(request);
    }

    @GetMapping(ProductRoutes.BUY_PRODUCT)
    public void buyProduct(@PathVariable Long productId, @PathVariable Long userId){
        productService.buyProduct(productId, userId);
    }

    @GetMapping(ProductRoutes.PAGINATION)
    public List<Product> getPaginatedList(@PathVariable int page, @PathVariable int size) {
        return productService.getPaginatedUserList(page, size);
    }

}
