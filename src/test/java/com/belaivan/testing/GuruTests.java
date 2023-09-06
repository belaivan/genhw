package com.belaivan.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GuruTests extends BaseTest {

    @Test(groups = "Selenium")
    public void guruFrameTest() {
        open("http://demo.guru99.com/test/guru99home");
        test().getGuru99Page().acceptGdpr();
        test().getGuru99Page().clickAdAndSwitchTab();
        Assert.assertEquals(test().getGuru99Page().clickAdAndSwitchTab(),
                "Selenium Live Project: FREE Real Time Project for Practice",
                "Tab title does not match");
        test().getGuru99Page().clickSeleniumAndSwitchTab();
        Assert.assertTrue(test().getGuru99Page().isSubmitButtonPresent(), "Submit button not present");
    }
}
