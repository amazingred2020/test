package com.senlainc.service;

import java.util.List;

public interface ReportService {

    List<String[]> generateRows();
    void writeToExelFile();
    List<String[]> readFromExelFile();
    void reporting();
}
