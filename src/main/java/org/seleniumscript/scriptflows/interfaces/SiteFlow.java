package org.seleniumscript.scriptflows.interfaces;

import org.openqa.selenium.WebDriver;

public interface SiteFlow {

    //login to a website with given credentials
    void login(String USER, String PW, WebDriver driver);
}
