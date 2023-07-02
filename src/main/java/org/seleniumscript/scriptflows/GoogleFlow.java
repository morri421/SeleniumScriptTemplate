package org.seleniumscript.scriptflows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumscript.services.ExcelFileService;
import org.seleniumscript.scriptflows.interfaces.SiteFlow;
import org.seleniumscript.services.BrowserService;

import java.util.HashMap;
import java.util.Map;

public class GoogleFlow implements SiteFlow {

    private String SITE_URL = "http://google.com";
    private String USER = "fakeemail@gmail.com";
    private String PW = "fake_password";
    private String excelFilePath = "C:/Users/devmo/Desktop/excel.xlsx";

    Logger logger = (Logger) LogManager.getLogger(GoogleFlow.class);

    private BrowserService browserService;
    private ExcelFileService excelFileService;

    public GoogleFlow() {
        this.browserService = new BrowserService();
        this.excelFileService = new ExcelFileService(excelFilePath);
    }

    public void start() {
        getExcelData();
        WebDriver browser = browserService.startUp();
        browserService.openUrl(SITE_URL, browser);
        try {
            login(USER, PW, browser);
        } catch(Exception e) {
            logger.info("Exception in GoogleFlow after browser setup: " + e.getMessage());
            browserService.quitBrowser(browser);
        }
    }

    //uses the file exampleexcel in the project directory
    public Map<String, String> getExcelData() {
        Map<String, String> excelData = new HashMap<>();
        XSSFWorkbook workbook = excelFileService.connectToExcel();
        XSSFSheet sheet = workbook.getSheetAt(0);

        //Skip the first row of headers
        int extractedRow = 1;
        while (null != sheet.getRow(extractedRow)) {
            try {
                String exampleKey = sheet.getRow(extractedRow).getCell(0).toString() + extractedRow;
                String exampleValue = sheet.getRow(extractedRow).getCell(1).getStringCellValue();
                excelData.put(exampleKey, exampleValue);
                extractedRow++;
                logger.info("Extracted key: " + exampleKey + " Extracted value: " + exampleValue);
            } catch (NullPointerException e) {
                logger.info("Could not extract data from excel from row: " + extractedRow);
                extractedRow++;
                excelFileService.closeExcel();
            }
        }
        logger.info("Excel Data Extraction Successful. Number of key/value pairs:  " + excelData.size());
        excelFileService.closeExcel();
        return  excelData;
    }

    @Override
    public void login(String USER, String PW, WebDriver driver) {
        WebElement loginButton = driver.findElement(By.className("gb_Jd"));
        loginButton.click();
        WebElement emailInput = driver.findElement(By.name("identifier"));
        emailInput.sendKeys(USER);
        emailInput.sendKeys(Keys.ENTER);
        //this login attempt will fail because its an unsecured login attempt
        //it's intended to be replaced with internal company urls
        //loginButton.click();
    }
}
