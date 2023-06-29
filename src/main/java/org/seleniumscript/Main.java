package org.seleniumscript;

import org.openqa.selenium.WebDriver;
import org.seleniumscript.services.BrowserService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BrowserService service = new BrowserService();
        WebDriver driver = service.startUp();
        driver.get("http://google.com");
        try {
            service.login(driver);
        } catch (Exception e) {
            service.quitBrowser(driver);
        }
    }
}