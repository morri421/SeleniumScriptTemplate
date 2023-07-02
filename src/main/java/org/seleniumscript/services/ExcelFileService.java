package org.seleniumscript.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelFileService {
    Logger logger = (Logger) LogManager.getLogger(ExcelFileService.class);

    FileInputStream inputStream;
    FileOutputStream outputStream;
    String excelFilePath;
    XSSFWorkbook workbook;

    public ExcelFileService(String excelFilePath) {
        this.excelFilePath = excelFilePath;
    }

    public XSSFWorkbook connectToExcel() {
        File excel = new File(excelFilePath);
        try {
            inputStream = new FileInputStream(excel);
            workbook = new XSSFWorkbook(inputStream);
            logger.info("Connected to Excel file successfully");
            return workbook;
        } catch (IOException e) {
            logger.info("ExcelFileService can't CONNECT to file with given ExcelFilePath: " + excelFilePath);
            throw new RuntimeException("Error with ExcelFileService");
        }
    }

    public void writeToExcel() {
        try {
            outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            logger.info("Wrote to Excel file successfully");
        } catch (Exception e) {
            logger.info("ExcelFileService can't WRITE to given file.");
            throw new RuntimeException(e);
        }
    }

    public void closeExcel() {
        try {
            workbook.close();
            logger.info("Closed Excel file successfully");
        } catch (IOException e) {
            logger.info("ExcelFileService can't close Excel file.");
            throw new RuntimeException(e);
        }
    }
}
