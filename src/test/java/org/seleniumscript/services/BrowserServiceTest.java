package org.seleniumscript.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BrowserServiceTest {

    private BrowserService testBrowserService;
    private WebDriver testWebDriver;

    @BeforeEach
    void setUp() {
        testBrowserService = new BrowserService();
        testWebDriver = testBrowserService.startUp();
    }

    @AfterEach
    void tearDown() {
        testBrowserService.quitBrowser(testWebDriver);
    }

    @Test
    void whenBrowserServiceGivenNullUrl_returnsNullPointer() {
        assertThrows(
                NullPointerException.class,
                () -> { testBrowserService.openUrl(null, testWebDriver);; }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void whenBrowserServiceGivenEmptyUrls_returnsInvalidArgumentException(String url) {
        assertThrows(
                InvalidArgumentException.class,
                () -> { testBrowserService.openUrl(url, testWebDriver);; }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"ashjdksjahdkjsad", "/';[-", "google.com", "http//google.com"})
    void whenBrowserServiceGivenInvalidUrls_returnsInvalidArgumentsException (String url) {
        assertThrows(
                InvalidArgumentException.class,
                () -> {
                    testBrowserService.openUrl(url, testWebDriver);
                }
        );
    }
}