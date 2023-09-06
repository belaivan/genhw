package com.belaivan.testing;

import com.belaivan.testing.drivermanager.DriverManager;
import com.belaivan.testing.pages.PageAndServiceHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private final PageAndServiceHandler pageAndServiceHandler = new PageAndServiceHandler();

    public void open(String url) {
        DriverManager.getInstance().getDriver().get(url);
    }

    @BeforeMethod(alwaysRun = true, onlyForGroups = "Selenium")
    public void setUp() {
        DriverManager.getInstance().getDriver();
    }

    @AfterMethod(alwaysRun = true, onlyForGroups = "Selenium")
    public void close() {
        DriverManager.getInstance().quitDriver();
    }

    public PageAndServiceHandler test() {
        return pageAndServiceHandler;
    }
}
