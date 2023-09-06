package com.belaivan.testing.pages.onlinehtmleditor;

import com.belaivan.testing.drivermanager.DriverManager;
import com.belaivan.testing.pages.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class OnlineHTMLEditorPage extends CommonPage {

    private final By denyCookiesButton = new By.ByXPath("//*[contains(@class, 'ch2-deny-all-btn')]");
    private final By textBox = new By.ByXPath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p");
    private final By boldToggle = new By.ByXPath("//*[contains(@class, 'cke_button__bold_icon')]");
    private final By underlineToggle = new By.ByXPath("//*[contains(@class, 'cke_button__underline_icon')]");

    public void denyCookies() {
        if (getDriver().findElement(denyCookiesButton).isDisplayed()) {
            getDriver().findElement(denyCookiesButton).click();
        }
    }

    public void sendBoldText(String text) {
        getDriver().findElement(boldToggle).click();
        switchToEditorFrame();
        getDriver().findElement(textBox).sendKeys(text);
        getDriver().switchTo().parentFrame();
        getDriver().findElement(boldToggle).click();

    }

    public void sendUnderlinedText(String text) {
        getDriver().findElement(underlineToggle).click();
        switchToEditorFrame();
        getDriver().findElement(textBox).sendKeys(text);
        getDriver().switchTo().parentFrame();
        getDriver().findElement(underlineToggle).click();
    }

    public void sendText(String text) {
        switchToEditorFrame();
        getDriver().findElement(textBox).sendKeys(text);
        getDriver().switchTo().parentFrame();
    }

    public boolean checkText(String text) {
        switchToEditorFrame();
        return text.equals(getDriver().findElement(textBox).getText());
    }

    private void switchToEditorFrame() {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
    }

    public WebDriver getDriver() {
        return DriverManager.getInstance().getDriver();
    }
}
