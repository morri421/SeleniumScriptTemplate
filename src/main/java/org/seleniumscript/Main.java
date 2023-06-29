package org.seleniumscript;

import org.openqa.selenium.WebDriver;
import org.seleniumscript.scriptflows.GoogleFlow;
import org.seleniumscript.services.BrowserService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GoogleFlow googleFlow = new GoogleFlow();
        googleFlow.start();
    }
}