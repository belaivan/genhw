package com.belaivan.testing.pages;

import com.belaivan.testing.pages.guru.Guru99Page;
import com.belaivan.testing.pages.onlinehtmleditor.OnlineHTMLEditorPage;
import com.belaivan.testing.pages.saucedemo.SauceDemoLoginPage;
import com.belaivan.testing.pages.saucedemo.SauceDemoShopPage;
import com.belaivan.testing.services.JsonPlaceHolder;

public class PageAndServiceHandler {

    private final SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
    private final SauceDemoShopPage sauceDemoShopPage = new SauceDemoShopPage();
    private final OnlineHTMLEditorPage onlineHTMLEditorPage = new OnlineHTMLEditorPage();
    private final Guru99Page guru99Page = new Guru99Page();

    private final JsonPlaceHolder jsonPlaceHolder = new JsonPlaceHolder();

    public SauceDemoLoginPage getSauceDemoLoginPage() {
        return sauceDemoLoginPage;
    }

    public SauceDemoShopPage getSauceDemoShopPage() {
        return sauceDemoShopPage;
    }

    public OnlineHTMLEditorPage getOnlineHTMLEditorPage() {
        return onlineHTMLEditorPage;
    }

    public Guru99Page getGuru99Page() {
        return guru99Page;
    }

    public JsonPlaceHolder getJsonPlaceHolder() {
        return jsonPlaceHolder;
    }
}
