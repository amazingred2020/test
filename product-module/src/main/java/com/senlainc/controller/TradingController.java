package com.senlainc.controller;

import com.senlainc.dto.product.AddProductRequest;
import com.senlainc.entity.Product;
import com.senlainc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/product")
public class TradingController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add")
    public Product addProductForSale(@RequestBody @Valid AddProductRequest request, BindingResult result){
        if(!result.hasErrors()){
            return productService.addProduct(request);
        }
        return null;
    }

    @GetMapping(value = "/buy")
    public void purchaseProduct(@RequestParam Long productId, @RequestParam Long buyerId){
        productService.buyProduct(productId, buyerId);
    }
}
