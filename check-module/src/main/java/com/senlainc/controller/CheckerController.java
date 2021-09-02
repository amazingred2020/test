package com.senlainc.controller;

import com.senlainc.dto.product.SaveProductCheckerRequest;
import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.ProductChecker;
import com.senlainc.entity.User;
import com.senlainc.enums.CheckerStatus;
import com.senlainc.routes.CheckerRoutes;
import com.senlainc.service.CheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @PostMapping(CheckerRoutes.MAKER)
    public void sendForChecking(@RequestBody @Validated SaveProductCheckerRequest request){
        checkerService.makerProducer(request);
    }

    @GetMapping(CheckerRoutes.CHECKER)
    public void sendApproveProduct(@PathVariable long id){
        checkerService.checkerProducer(id);
    }
}
