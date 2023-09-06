package com.belaivan.testing.pages.saucedemo;

import com.belaivan.testing.drivermanager.DriverManager;
import com.belaivan.testing.pages.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SauceDemoShopPage extends CommonPage {

    private final By backpackItem = new By.ById("add-to-cart-sauce-labs-backpack");
    private final By jacketItem = new By.ById("add-to-cart-sauce-labs-fleece-jacket");

    private final By shoppingCart = new By.ByClassName("shopping_cart_badge");
    private final By checkoutButton = new By.ById("checkout");
    private final By firstNameField = new By.ById("first-name");
    private final By lastNameField = new By.ById("last-name");
    private final By zipCodeField = new By.ById("postal-code");
    private final By continueButton = new By.ById("continue");
    private final By finishButton = new By.ById("finish");
    private final By successMessage = By.className("complete-header");

    private final By footer = new By.ByClassName("footer_copy");

    public void addBackpackAndJacket() {
        waitUntil(wd -> getDriver().findElement(backpackItem).isDisplayed(), 10);
        getDriver().findElement(backpackItem).click();
        getDriver().findElement(jacketItem).click();
    }

    public String getNumberOfCartItems() {
        return getDriver().findElement(shoppingCart).getText();
    }

    public void checkoutItems() {
        getDriver().findElement(shoppingCart).click();
        getDriver().findElement(checkoutButton).click();
        getDriver().findElement(firstNameField).sendKeys("Performance");
        getDriver().findElement(lastNameField).sendKeys("Glitch User");
        getDriver().findElement(zipCodeField).sendKeys("1104");
        getDriver().findElement(continueButton).click();
        getDriver().findElement(finishButton).click();
    }

    public boolean isPurchaseSuccessful() {
        return "Thank you for your order!".equals(getDriver().findElement(successMessage).getText());
    }

    public boolean isFooterPresent() {
        WebElement footerElement = getDriver().findElement(footer);
        new Actions(getDriver()).scrollToElement(footerElement).perform();
        return footerElement.getText().contains("2023") && footerElement.getText().contains("Terms of Service");
    }

    public WebDriver getDriver() {
        return DriverManager.getInstance().getDriver();
    }
}
