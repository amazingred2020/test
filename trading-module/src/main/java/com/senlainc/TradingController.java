package com.senlainc;

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

    @PostMapping(value = "/add")
    public void putProductForSale(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @GetMapping(value = "/buy")
    public void purchaseProduct(@RequestParam Long productId, @RequestParam Long buyerId){
        User buyer = userService.findUserById(buyerId);
        Product product = productService.findProductById(productId);
        if(buyer.getAccount().getAccountPrice().compareTo(product.getPrice()) > 0){
            User seller = product.getSeller();
            buyer.getAccount().withdrawMoney(product.getPrice());
            seller.getAccount().putMoney(product.getPrice());
        }
    }
}
