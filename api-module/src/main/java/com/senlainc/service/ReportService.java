package com.senlainc.service;

import com.senlainc.entity.Product;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ReportService {

    void validateAndSave(MultipartFile file);
    List<Product> readFromExelFile(MultipartFile file);
}
