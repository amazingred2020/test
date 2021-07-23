package com.senlainc.controller;

import com.senlainc.entity.Product;
import com.senlainc.entity.User;
import com.senlainc.service.ProductService;
import com.senlainc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/trade")
public class TradingController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;
/*
    @PostMapping(value = "/add/{userid}")
    public void putProductForSale(@RequestBody Product product, @PathVariable Long userid){
        userDetailService.checkUserAccount(userid);
        product.setUser(userService.findUserById(userid));
        productService.saveProduct(product);
    }

    @GetMapping(value = "/buy")
    public void purchaseProduct(@RequestParam Long productId, @RequestParam Long buyerId){
        UserDetail buyerUserDetail = userDetailService.findUserDetailByUserId(buyerId);
        Product product = productService.findProductById(productId);
        if(productService.checkSolvency(buyerUserDetail.getAccount().getAccountPrice(), product.getPrice()) > 0){
            UserDetail sellerUserDetail = userDetailService.findUserDetailByUserId(product.getSeller().getId());
            buyerUserDetail.getAccount().withdrawMoney(product.getPrice());
            sellerUserDetail.getAccount().putMoney(product.getPrice());
            productService.deleteProduct(productId);
        }
    }*/
}
