package org.seleniumscript.services;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserService {

    public WebDriver startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-javascript");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public void openUrl(String SITE_URL, WebDriver driver) {
        driver.get(SITE_URL);
    }

    public void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}
