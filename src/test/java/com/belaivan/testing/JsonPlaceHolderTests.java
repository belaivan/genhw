package com.belaivan.testing;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.Response;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class JsonPlaceHolderTests extends BaseTest {

    public Logger logger = Logger.getLogger(JsonPlaceHolderTests.class);

    @Test
    public void jsonPlaceHolderTest() throws IOException {
        Response response = test().getJsonPlaceHolder().getUsers();
        Assert.assertEquals(response.code(), 200, "Response not 200");
        JsonArray jsonArray = JsonParser.parseString(response.body().string()).getAsJsonArray();
        for(JsonElement element: jsonArray) {
            logger.info(element.getAsJsonObject().get("name"));
            logger.info(element.getAsJsonObject().get("email"));
        }
        Assert.assertTrue(jsonArray.get(0).getAsJsonObject().get("email").getAsString().contains("@"), "First email does not contain @");
    }
}
