package com.belaivan.testing;

import com.belaivan.testing.dataprovider.DataProviders;
import com.belaivan.testing.pojo.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceTests extends BaseTest {

    @Test(dataProvider = "getCredentials", dataProviderClass = DataProviders.class, groups = "Selenium")
    public void automatePurchaseProcess(Credentials credentials) {
        open("https://www.saucedemo.com/");
        test().getSauceDemoLoginPage().login(credentials.getUsername(), credentials.getPassword());
        test().getSauceDemoShopPage().addBackpackAndJacket();
        Assert.assertEquals(test().getSauceDemoShopPage().getNumberOfCartItems(), "2", "Cart should contain 2 items");
        test().getSauceDemoShopPage().checkoutItems();
        Assert.assertTrue(test().getSauceDemoShopPage().isPurchaseSuccessful(), "Success message does not appear");
    }

    @Test(dataProvider = "getUserNamePassword", dataProviderClass = DataProviders.class, groups = "Selenium")
    public void verifyErrorMessages(String username, String password) {
        open("https://www.saucedemo.com/inventory.html");
        test().getSauceDemoLoginPage().loginWithoutCredentials();
        Assert.assertTrue(test().getSauceDemoLoginPage().checkErrorMessageOnIncorrectLogin(), "Error message does not appear");
        test().getSauceDemoLoginPage().login(username, password);
        Assert.assertTrue(test().getSauceDemoShopPage().isFooterPresent(), "Footer is not present");
    }
}
