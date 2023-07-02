package org.seleniumscript.scriptflows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumscript.services.ExcelFileService;
import org.seleniumscript.scriptflows.interfaces.SiteFlow;
import org.seleniumscript.services.BrowserService;

public class GoogleFlow implements SiteFlow {

    private String SITE_URL = "http://google.com";
    private String USER = "fakeemail@gmail.com";
    private String PW = "fake_password";
    private String excelFilePath = "C:/Users/devmo/Desktop/excel.xlsx";

    Logger logger = (Logger) LogManager.getLogger(GoogleFlow.class);

    private BrowserService browser;
    private ExcelFileService excelFileService;

    public GoogleFlow() {
        this.browser = new BrowserService();
        this.excelFileService = new ExcelFileService(excelFilePath);
    }

    public void start() {
        WebDriver browser = this.browser.startUp();
        openSite(SITE_URL, browser);
        try {
            openSite(SITE_URL, browser);
            login(USER, PW, browser);
        } catch(Exception e) {
            logger.info("Exception in GoogleFlow after browser setup");
            this.browser.quitBrowser(browser);
        }
    }

    @Override
    public void openSite(String SITE_URL, WebDriver driver) {
        driver.get(SITE_URL);
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
    }
}
