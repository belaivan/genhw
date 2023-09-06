package com.belaivan.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TextEditorTests extends BaseTest {

    @Test(groups = "Selenium")
    public void textEditor() {
        open("https://onlinehtmleditor.dev");
        test().getOnlineHTMLEditorPage().denyCookies();
        test().getOnlineHTMLEditorPage().sendBoldText("Automation ");
        test().getOnlineHTMLEditorPage().sendUnderlinedText("Test ");
        test().getOnlineHTMLEditorPage().sendText("Example");
        Assert.assertTrue(test().getOnlineHTMLEditorPage().checkText("Automation Test Example"), "Text does not match");
    }
}
