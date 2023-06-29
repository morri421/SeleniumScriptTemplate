package org.seleniumscript.services;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;

public class BrowserService {

    public WebDriver startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-javascript");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public void login(WebDriver driver) throws InterruptedException {
        WebElement loginButton = driver.findElement(By.className("gb_Jd"));
        loginButton.click();
        WebElement emailInput = driver.findElement(By.name("identifier"));
        emailInput.sendKeys("email1@gmail.com");
        emailInput.sendKeys(Keys.ENTER);
        //this login attempt will fail because its an unsecured login attempt
        //it's intended as an example
    }

    public void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}
