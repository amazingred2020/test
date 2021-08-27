package com.senlainc.report;

import com.senlainc.entity.Product;
import com.senlainc.entity.User;
import com.senlainc.service.ProductService;
import com.senlainc.service.ReportService;
import com.senlainc.service.UserService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
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

    private List<String[]> generateRows() {
        List<String> rows = new ArrayList<>();
        Random random = new Random();
        DecimalFormat formatter = new DecimalFormat("#.##");
        StringBuilder stringBuilder = new StringBuilder();
        int step = 1;

        for (int i = 0; i < 100; i++) {
            stringBuilder.append("product name " + step + "\t");
            stringBuilder.append("product description " + step++ + "\t");
            stringBuilder.append(formatter.format(random.nextDouble() * 50000) + "\t");
            stringBuilder.append(random.nextInt(10)+1);
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
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        SXSSFSheet sheet = workbook.createSheet("Products");
        Row row;
        Cell cell;
        String[] currentFields;

        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setBold(true);
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        style.setFont(font);
        row = sheet.createRow(0);

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

        sheet.trackAllColumnsForAutoSizing();
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);

        File file = new File("./product-module/src/products.xlsx");
        if(!file.exists()){
            try {
                file.getParentFile().mkdir();
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        try (FileOutputStream out = new FileOutputStream(file)) {
            workbook.write(out);
            workbook.dispose();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Product> readFromExelFile(MultipartFile file) {
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();

        List<Product> productList = new ArrayList<>();
        XSSFSheet sheet = workbook.getSheet("Products");
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();

        XSSFRow row = null;
        XSSFCell cell = null;
        int currentCellNumber = 3;
        Product product = null;
        User user = null;

        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            product = new Product();
            cell = row.getCell(currentCellNumber--);
            user = new User();
            user.setId(Long.valueOf(cell.getStringCellValue()));
            product.setUser(user);
            cell = row.getCell(currentCellNumber--);
            product.setPrice(new BigDecimal(cell.getStringCellValue().replace(",", ".")));
            cell = row.getCell(currentCellNumber--);
            product.setDescription(cell.getStringCellValue());
            cell = row.getCell(currentCellNumber);
            product.setName(cell.getStringCellValue());
            productList.add(product);
            currentCellNumber = 3;
        }

        return productList.stream()
                .map(p -> CompletableFuture.supplyAsync(() -> isExistedUser(p)))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    private Product isExistedUser(Product product){
        product.setUser(userService.findByAnyId(product.getUser().getId()));
        return product;
    }

    public List<Product> readFromExelFile1(MultipartFile file) {
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        XSSFSheet sheet = workbook.getSheet("Products");
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();
        XSSFRow row = null;
        XSSFCell cell = null;
        int currentCellNumber = 3;
        List<Future<Product>> futureList = new ArrayList<>();

        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            XSSFRow finalRow = row;
            futureList.add(CompletableFuture.supplyAsync(() -> getProductAsync(finalRow, currentCellNumber)));
        }

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()])).join();
        System.out.println("Времени потрачено: " + (System.currentTimeMillis() - start));
        return futureList.stream().map(this::getProduct).collect(Collectors.toList());
    }

    private Product getProductAsync(XSSFRow row, int currentCellNumber){
        Product product = new Product();
        XSSFCell cell = null;
        cell = row.getCell(currentCellNumber--);;
        product.setUser(userService.findUserById(Long.valueOf(cell.getStringCellValue())));
        cell = row.getCell(currentCellNumber--);
        product.setPrice(new BigDecimal(cell.getStringCellValue().replace(",", ".")));
        cell = row.getCell(currentCellNumber--);
        product.setDescription(cell.getStringCellValue());
        cell = row.getCell(currentCellNumber);
        product.setName(cell.getStringCellValue());
        return product;
    }

    private Product getProduct(Future<Product> future){
        Product product = null;
        try {
            product = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void validateAndSave(MultipartFile file){
        List<Product> productList = readFromExelFile(file);
        productList.stream()
                .filter(product -> Objects.nonNull(product.getUser()))
                .map(product -> CompletableFuture.runAsync(() -> {productService.saveProduct(product);}))
                .forEach(CompletableFuture::join);
    }
}
