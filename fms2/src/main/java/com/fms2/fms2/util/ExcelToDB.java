package com.fms2.fms2.util;

import com.fms2.fms2.inboundDetails.domain.InboundDetails;
import com.fms2.fms2.inboundDetails.service.InboundDetailsService;
import com.fms2.fms2.product.domain.Product;
import com.fms2.fms2.product.service.ProductService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelToDB {

    public static void getProductsFromExcel(ProductService productService) throws IOException {
        File file = new File("E:\\工作簿1.xlsx");
        FileInputStream fis = new FileInputStream(file);
        if ("E:\\工作簿1.xlsx".endsWith(".xlsx")) {
            //得到工作簿
            Workbook workbook = new XSSFWorkbook(fis);
            //得到一个工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
            //获得所有数据
            List<String> list = new ArrayList<>();
            for (int i = 0; i <= totalRowNum; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Product product = new Product();
                    for (int j = 0; j < 4; j++) {
                        switch (j) {
                            case 0:
                                product.setProductID(row.getCell(j).toString());
                                break;
                            case 1:
                                product.setProductName(row.getCell(j).toString());
                                break;
                            case 2:
                                product.setStandard(row.getCell(j).toString());
                                break;
                            case 3:
                                product.setUnit(row.getCell(j).toString());
                                break;
                        }
                    }
                    productService.addProduct(product);
                    System.out.println("product:" + product + "已写入");
                }
            }
        }
    }

    public static void getInboundsDetailFromExcel(InboundDetailsService inboundDetailsService) throws IOException {
        File file = new File("E:\\工作簿1.xlsx");
        FileInputStream fis = new FileInputStream(file);
        if ("E:\\工作簿1.xlsx".endsWith(".xlsx")) {
            //得到工作簿
            Workbook workbook = new XSSFWorkbook(fis);
            //得到一个工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
            //获得所有数据
            List<String> list = new ArrayList<>();
            for (int i = 0; i <= totalRowNum; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    InboundDetails inboundDetails = new InboundDetails();
                    for (int j = 0; j < 8; j++) {
                        switch (j) {
                            case 0:
                                inboundDetails.setDeliveryNumber(row.getCell(j).toString());
                                break;
//                            case 1:
//                                inboundDetails.setInboundDate(row.getCell(j).getDateCellValue().toString());
//                                break;
                            case 2:
                                inboundDetails.setProductID(row.getCell(j).toString());
                                break;
                            case 3:
                                inboundDetails.setUnitPrice(row.getCell(j).getNumericCellValue());
                                break;
                            case 5:
                                inboundDetails.setAmountOfThisPurchase(row.getCell(j).getNumericCellValue());
                                break;
                            case 6:
                                inboundDetails.setComment(row.getCell(j).getStringCellValue());
                                break;
                            case 7:
                                inboundDetails.setSupplier(row.getCell(j).getStringCellValue());
                                break;
                        }
                    }
                    inboundDetailsService.addInboundDetails(inboundDetails);
                }

            }
        }
    }


    public static void generateInvoice(List<InboundDetails> inboundDetailsList, HttpServletResponse response) throws IOException {
        File file = ResourceUtils.getFile("classpath:入库单模板.xlsx");
        FileInputStream fis = new FileInputStream(file);

        //得到工作簿
        Workbook workbook = new XSSFWorkbook(fis);
        System.out.println("workbook:" +workbook);
        //得到一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        InboundDetails inboundDetails;

        for (int i = 0; i < inboundDetailsList.size(); i++) {
            inboundDetails = inboundDetailsList.get(i);
            if (i == 0) {
                sheet.getRow(1).getCell(5).setCellValue(inboundDetails.getInboundId());
                sheet.getRow(2).getCell(2).setCellValue(inboundDetails.getSupplier());
                sheet.getRow(2).getCell(5).setCellValue("电话");
                sheet.getRow(2).getCell(9).setCellValue(inboundDetails.getInboundDate());
            }
            sheet.getRow(5 + i).getCell(2).setCellValue(inboundDetails.getProductID());
            sheet.getRow(5 + i).getCell(5).setCellValue(inboundDetails.getUnit());
            sheet.getRow(5 + i).getCell(6).setCellValue(inboundDetails.getUnitPrice());
            sheet.getRow(5 + i).getCell(7).setCellValue(inboundDetails.getInboundQuantity());
            sheet.getRow(5 + i).getCell(8).setCellValue(inboundDetails.getAmountOfThisPurchase());
            sheet.getRow(5 + i).getCell(9).setCellValue(inboundDetails.getComment());
        }


//        File outFile = new File("E:\\工作簿3.xlsx");
//        FileOutputStream fos = new FileOutputStream(outFile);

        // 将Excel文件写入到响应流
        response.reset();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8");
        try {
            response.addHeader("Content-Disposition", "attachment;filename=inboundInvoice.xlsx");
            OutputStream out = response.getOutputStream();
            workbook.write(out);

            out.flush();
            out.close();
            workbook.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
