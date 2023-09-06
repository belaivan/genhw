package com.belaivan.testing.pages.guru;

import com.belaivan.testing.drivermanager.DriverManager;
import com.belaivan.testing.pages.CommonPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Guru99Page extends CommonPage {

    private final By acceptGdprButton = new By.ById("save");
    private final By gdprFrame = new By.ByXPath("//iframe[@class='faktor-iframe-wrapper']");
    private final By adIframe = new By.ByXPath("//iframe[@src='ads.html']");
    private final By adPicture = new By.ByXPath("/html/body");
    private final By seleniumPicture = new By.ByLinkText("Selenium");
    private final By submitButton = new By.ByClassName("submit");
    private final By seleniumGdprButton = new By.ByXPath("//*[text()='AGREE']");

    public void acceptGdpr() {
        new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(gdprFrame));
        waitUntil(wd -> getDriver().findElement(acceptGdprButton).isDisplayed(), 10);
        if (getDriver().findElement(acceptGdprButton).isDisplayed()) {
            getDriver().findElement(acceptGdprButton).click();
        }
    }

    public String clickAdAndSwitchTab() {
        String originalTab = getDriver().getWindowHandle();
        WebElement iFrameElement = getDriver().findElement(adIframe);
        getDriver().switchTo().frame(iFrameElement);
        getDriver().findElement(adPicture).click();
        for (String tabHandle: getDriver().getWindowHandles()) {
            if (!tabHandle.equals(originalTab)) {
                getDriver().switchTo().window(tabHandle);
            }
        }
        String title = getDriver().getTitle();
        getDriver().close();
        getDriver().switchTo().window(originalTab);
        return title;
    }

    public void clickSeleniumAndSwitchTab() {
        getDriver().findElement(seleniumPicture).click();
        new Actions(getDriver()).keyDown(Keys.ENTER).perform();
        waitUntil(wd -> getDriver().findElement(seleniumGdprButton).isDisplayed(), 5);
        new Actions(getDriver()).keyDown(Keys.ESCAPE).perform();
    }

    public boolean isSubmitButtonPresent() {
        waitUntil(wd -> getDriver().findElement(submitButton).isDisplayed(), 5);
        return getDriver().findElement(submitButton).isDisplayed();
    }

    public WebDriver getDriver() {
        return DriverManager.getInstance().getDriver();
    }
}
