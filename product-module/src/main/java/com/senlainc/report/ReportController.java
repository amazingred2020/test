package com.senlainc.report;

import com.senlainc.routes.ReportRoutes;
import com.senlainc.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = ReportRoutes.GET_FILE)
    public HttpEntity<ByteArrayResource> getExcelFile(){
        byte[] output = reportService.generateExelFile();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Products.xlsx");

        return new HttpEntity<>(new ByteArrayResource(output), responseHeaders);
    }

    @PostMapping(ReportRoutes.REPORT)
    public boolean validateAndSaveProducts(@RequestParam MultipartFile file){
        return reportService.validateAndSave(file);
    }
}
