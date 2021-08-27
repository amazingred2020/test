package com.senlainc.report;

import com.senlainc.entity.Product;
import com.senlainc.routes.ReportRoutes;
import com.senlainc.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping(value = ReportRoutes.PRODUCTS)
    public List<Product> getProductsFromExcel(@RequestParam MultipartFile file){
        List<Product> productList = reportService.readFromExelFile(file);
        return productList;
    }

    @PostMapping(value = ReportRoutes.REPORT)
    public void validateAndSaveProducts(@RequestParam MultipartFile file){
        reportService.validateAndSave(file);
    }
}
