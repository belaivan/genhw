package com.belaivan.testing.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    protected WebDriver driver;
    private static DriverManager instance = null;

    private DriverManager() {
    }

    public static synchronized DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }

        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }

        return driver;
    }

    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
