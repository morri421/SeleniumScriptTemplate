package org.seleniumscript.services;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserService {

    Logger logger = (Logger) LogManager.getLogger(BrowserService.class);

    public WebDriver startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-javascript");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public void openUrl(String SITE_URL, WebDriver driver) {
        driver.get(SITE_URL);
        logger.info("Opened given url successfully");
    }

    public void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}
