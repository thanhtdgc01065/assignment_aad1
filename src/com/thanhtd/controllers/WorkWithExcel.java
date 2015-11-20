//http://kodejava.org/how-do-i-create-an-excel-document-using-apache-poi/
//http://kodejava.org/how-do-i-read-excel-file/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.controllers;

import com.thanhtd.models.Order;
import com.thanhtd.models.OrderDetail;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author trduy
 */
public class WorkWithExcel {

    public static void ExportToExcel(Order item, List<OrderDetail> list) {
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet("Order Number " + item.getID());

        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        cellStyle.setFont(font);

        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("ORDER NUMBER" + item.getID());

        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue("Order ID: " + item.getID());

        row = sheet.createRow(3);
        cell = row.createCell(0);
        cell.setCellValue("Customer Name: " + item.getCusName());

        row = sheet.createRow(4);
        cell = row.createCell(0);
        cell.setCellValue("Customer Address: " + item.getCusAdd());

        row = sheet.createRow(5);
        cell = row.createCell(0);
        cell.setCellValue("Customer Tel: " + item.getCusTel());

        row = sheet.createRow(6);
        cell = row.createCell(0);
        cell.setCellValue("Customer Email: " + item.getCusEmail());

        row = sheet.createRow(8);
        cell = row.createCell(0);
        cell.setCellValue("Order Details");

        row = sheet.createRow(9);
        cell = row.createCell(0);
        cell.setCellValue("Product");
        cell = row.createCell(1);
        cell.setCellValue("Price");
        cell = row.createCell(2);
        cell.setCellValue("Quantity");
        cell = row.createCell(3);
        cell.setCellValue("Total");

        int rowCount = 10;
        double total = 0;
        for (OrderDetail list1 : list) {
            row = sheet.createRow(rowCount++);
            cell = row.createCell(0);
            cell.setCellValue(list1.getProductName());
            row.getSheet().autoSizeColumn(0);
            cell = row.createCell(1);
            cell.setCellValue("$" + list1.getProductPrice());
            row.getSheet().autoSizeColumn(1);
            cell = row.createCell(2);
            cell.setCellValue(list1.getQuantity());
            total += list1.getProductPrice() * list1.getQuantity();
            row.getSheet().autoSizeColumn(2);
            cell = row.createCell(3);
            cell.setCellValue("$" + total);
            row.getSheet().autoSizeColumn(3);
        }

        row = sheet.createRow(rowCount);
        cell = row.createCell(0);
        cell.setCellValue("TOTAL");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(3);
        cell.setCellValue("$" + total);
        cell.setCellStyle(cellStyle);

        try (FileOutputStream outputStream = new FileOutputStream("OrderNumber" + item.getID() + ".xlsx")) {
            workBook.write(outputStream);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WorkWithExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WorkWithExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}