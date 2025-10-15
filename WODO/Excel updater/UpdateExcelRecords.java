package com.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class UpdateExcelRecords {

    public static void main(String[] args) {
        // Column names
        String[] columns = {"ID", "Name", "Marks"};

        // Student data
        Object[][] studentData = {
            {1, "Alice", 95},
            {2, "Bob", 89},
            {3, "Charlie", 92},
            {4, "David", 88},
            {5, "Eva", 97},
            {6, "Hannah", 76},
            {7, "Ivy", 73},
            {8, "Jack", 82},
            {9, "Liam", 90},
            {10, "Mia", 85}
        };

        // Create workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Student Records");

        // Create header row
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        // Write student data rows
        int rowNum = 1;
        for (Object[] record : studentData) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < record.length; i++) {
                if (record[i] instanceof String) {
                    row.createCell(i).setCellValue((String) record[i]);
                } else if (record[i] instanceof Integer) {
                    row.createCell(i).setCellValue((Integer) record[i]);
                }
            }
        }

        // Auto-size all columns
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to Excel file
        try (FileOutputStream fileOut = new FileOutputStream("StudentRecords.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
