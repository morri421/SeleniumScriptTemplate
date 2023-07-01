package org.seleniumscript.scriptflows.interfaces;

import org.openqa.selenium.WebDriver;

public interface SiteFlow {

    //open a website with a given url
    void openSite(String SITE_URL, WebDriver driver);

    //login to a website with given credentials
    void login(String USER, String PW, WebDriver driver);
}
