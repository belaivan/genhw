package com.belaivan.testing.pages.saucedemo;

import com.belaivan.testing.drivermanager.DriverManager;
import com.belaivan.testing.pages.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoLoginPage extends CommonPage {

    private final By usernameField = new By.ById("user-name");
    private final By passwordField = new By.ById("password");
    private final By loginButton = new By.ById("login-button");
    private final By errorMessage = new By.ByXPath("//*[@data-test='error']");

    public void login(String username, String password) {
        waitUntil(wd -> DriverManager.getInstance().getDriver().findElement(usernameField).isDisplayed(), 5);
        getDriver().findElement(usernameField).sendKeys(username);
        getDriver().findElement(passwordField).sendKeys(password);
        getDriver().findElement(loginButton).click();
    }

    public void loginWithoutCredentials() {
        waitUntil(wd -> getDriver().findElement(usernameField).isDisplayed(), 5);
        getDriver().findElement(loginButton).click();
    }

    public boolean checkErrorMessageOnIncorrectLogin() {
        return "Epic sadface: Username is required"
                .equals(getDriver().findElement(errorMessage).getText());
    }

    public WebDriver getDriver() {
        return DriverManager.getInstance().getDriver();
    }
}
