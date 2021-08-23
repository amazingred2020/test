package com.senlainc.report;

import com.senlainc.routes.ReportRoutes;
import com.senlainc.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(ReportRoutes.REPORT)
    public void validateExcelFile(){
        reportService.reporting();
    }

    @GetMapping(ReportRoutes.GET_EXCEL_FILE)
    public void generateProductExcelFile(){
        reportService.writeToExelFile();
    }
}
