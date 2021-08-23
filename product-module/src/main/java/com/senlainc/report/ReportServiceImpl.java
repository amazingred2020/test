package com.senlainc.report;

import com.senlainc.dto.product.FieldsObject;
import com.senlainc.entity.User;
import com.senlainc.service.ProductService;
import com.senlainc.service.ReportService;
import com.senlainc.service.UserService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    public List<String[]> generateRows() {
        List<String> rows = new ArrayList<>();
        Random random = new Random();
        DecimalFormat formatter = new DecimalFormat("#.##");
        StringBuilder stringBuilder = new StringBuilder();
        int step = 1;

        for (int i = 0; i < 4000; i++) {
            stringBuilder.append("product name " + step + "\t");
            stringBuilder.append("product description " + step++ + "\t");
            stringBuilder.append(formatter.format(random.nextDouble() * 50000) + "\t");
            stringBuilder.append(random.nextInt(20)+1);
            rows.add(stringBuilder.toString());
            stringBuilder.trimToSize();
            stringBuilder.setLength(0);
        }

        List<String[]> array = rows.stream().map(s -> s.split("\t"))
                .collect(Collectors.toList());
        return array;
    }

    public void writeToExelFile() {
        List<String[]> rows = generateRows();

        int cellNumber = 0;
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Products");
        Row row;
        Cell cell;
        String[] currentFields;

        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setBold(true);
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        style.setFont(font);
        row = sheet.createRow(0);
        currentFields = rows.get(0);
        row.createCell(cellNumber, CellType.STRING).setCellValue("Название");
        row.getCell(cellNumber++).setCellStyle(style);
        row.createCell(cellNumber, CellType.STRING).setCellValue("Описание");
        row.getCell(cellNumber++).setCellStyle(style);
        row.createCell(cellNumber, CellType.STRING).setCellValue("Стоимость");
        row.getCell(cellNumber++).setCellStyle(style);
        row.createCell(cellNumber, CellType.STRING).setCellValue("ID продавца");
        row.getCell(cellNumber).setCellStyle(style);
        cellNumber = 0;

        for(int i = 1; i <= rows.size(); i++){
            row = sheet.createRow(i);
            currentFields = rows.get(i - 1);

            cell = row.createCell(cellNumber, CellType.STRING);
            cell.setCellValue(currentFields[cellNumber++]);

            cell = row.createCell(cellNumber, CellType.STRING);
            cell.setCellValue(currentFields[cellNumber++]);

            cell = row.createCell(cellNumber, CellType.NUMERIC);
            cell.setCellValue(currentFields[cellNumber++]);

            cell = row.createCell(cellNumber, CellType.NUMERIC);
            cell.setCellValue(currentFields[cellNumber]);

            cellNumber = 0;
        }
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);

        try (FileOutputStream out = new FileOutputStream("src/products.xlsx")) {
            workbook.write(out);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<String[]> readFromExelFile() {
        writeToExelFile();

        XSSFWorkbook workbook = null;
        try (FileInputStream inputStream = new FileInputStream("src/products.xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e){
            e.printStackTrace();
        }

        List<String> productList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        XSSFSheet sheet = workbook.getSheet("Products");
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();
        XSSFRow row;
        Iterator<Cell> cellIterator;
        XSSFCell cell;
        while (rowIterator.hasNext()){
            row = (XSSFRow) rowIterator.next();
            cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                cell = (XSSFCell) cellIterator.next();
                stringBuilder.append(cell.getStringCellValue()).append("|");
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            productList.add(stringBuilder.toString().replace(",", "."));
            stringBuilder.trimToSize();
            stringBuilder.setLength(0);
        }

        List<String[]> array = productList.stream().map(s -> s.split("\\|"))
                .collect(Collectors.toList());

        return array;
    }

    public boolean isExist(String[] array){
        if(userService.findUserById(Long.valueOf(array[3])) != null){
            return true;
        }
        return false;
    }

    public FieldsObject isExistedUser(String[] array){
        User user = userService.findUserById(Long.valueOf(array[3]));
        if(user != null){
            return new FieldsObject(user, array);
        }
        return new FieldsObject(null, array);
    }

    public void saveProduct(FieldsObject fields){
        if(fields.getUser() != null){
            productService.addProduct(fields);
        }

    }

    public void reporting(){
        List<String[]> fileRows = readFromExelFile();
        
        long start = System.currentTimeMillis();
        /*
        fileRows.stream()
                .map(array -> CompletableFuture.supplyAsync(() -> isExistedUser(array)))
                .map(CompletableFuture -> CompletableFuture.thenAccept(this::saveProduct))
                .forEach(CompletableFuture<Void>::join);
             */
        fileRows.parallelStream()
                .filter(this::isExist)
                .map(array -> CompletableFuture.runAsync(() -> {productService.addProductFromArray(array);}))
                .forEach(CompletableFuture<Void>::join);

        System.out.println("Потраченное время: " + (System.currentTimeMillis()-start));

    }
}
