package org.seleniumscript.scriptflows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumscript.interfaces.SiteFlow;
import org.seleniumscript.services.BrowserService;

public class GoogleFlow implements SiteFlow {

    private String SITE_URL = "http://google.com";
    private String USER = "fakeemail@gmail.com";
    private String PW = "fake_password";

    public void start() {
        BrowserService browser = new BrowserService();
        WebDriver driver = browser.startUp();
        try {
            openSite(SITE_URL, driver);
            login(USER, PW, driver);
        } catch(Exception e) {
            browser.quitBrowser(driver);
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
        //it's intended as an example
    }
}
