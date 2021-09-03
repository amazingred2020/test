package com.senlainc.controller;

import com.senlainc.dto.product.SaveProductCheckerRequest;
import com.senlainc.entity.ProductChecker;
import com.senlainc.routes.CheckerRoutes;
import com.senlainc.service.CheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckerController {

    @Autowired
    private CheckerService checkerService;

    @GetMapping(CheckerRoutes.PRODUCT_BY_ID)
    public ProductChecker getProductById(@PathVariable long id){
        return checkerService.getProductById(id);
    }

    @GetMapping(CheckerRoutes.PRODUCTS)
    public List<ProductChecker> getPendingProducts(){
        return checkerService.getAllPendingProducts();
    }

    @PostMapping(CheckerRoutes.VALIDATE)
    public void sendForChecking(@RequestBody @Validated SaveProductCheckerRequest request){
        checkerService.makerProducer(request);
    }

    @GetMapping(CheckerRoutes.REJECT)
    public void rejectUpdateProduct(@PathVariable long id){
        checkerService.rejectUpdate(id);
    }

    @GetMapping(CheckerRoutes.APPROVE)
    public void approveUpdateProduct(@PathVariable long id){
        checkerService.checkerProducer(id);
    }
}
