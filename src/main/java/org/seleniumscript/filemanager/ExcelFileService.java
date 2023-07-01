package org.seleniumscript.filemanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFileService {
    Logger logger = (Logger) LogManager.getLogger(ExcelFileService.class);

    FileInputStream inputStream;
    String excelFilePath;

    public ExcelFileService(String excelFilePath) {
        this.excelFilePath = excelFilePath;
    }

    public XSSFWorkbook connectToExcel() {
        File excel = new File(excelFilePath);
        XSSFWorkbook workbook = null;
        try {
            inputStream = new FileInputStream(excel);
            workbook = new XSSFWorkbook(inputStream);
            return workbook;
        } catch (IOException e) {
            logger.info("ExcelFileService cannot connect to file with given ExcelFilePath: " + excelFilePath);
            throw new RuntimeException("Error with ExcelFileService");
        }
    }

}
