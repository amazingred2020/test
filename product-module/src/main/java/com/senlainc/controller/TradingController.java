package com.senlainc.controller;

import com.senlainc.dto.product.AddProductRequest;
import com.senlainc.entity.Product;
import com.senlainc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class TradingController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add")
    public Product addProductForSale(@RequestBody @Validated AddProductRequest request){
        return productService.addProduct(request);
    }

    @GetMapping(value = "/buy/{productId}/{userId}")
    public void purchaseProduct(@PathVariable Long productId, @PathVariable Long buyerId){
        productService.buyProduct(productId, buyerId);
    }
}
