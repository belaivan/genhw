package com.belaivan.testing.dataprovider;

import com.belaivan.testing.pojo.Credentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class DataProviders {

    @DataProvider
    public static Object[][] getCredentials() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Credentials credentials = objectMapper
                .readValue(new File("src/test/resources/performanceGlitchUser.json"), Credentials.class);
        return new Object[][]{
                new Object[]{credentials}
        };
    }

    @DataProvider
    public static Object[][] getUserNamePassword() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Credentials credentials = objectMapper
                .readValue(new File("src/test/resources/standardUser.json"), Credentials.class);
        return new Object[][]{
                new Object[]{credentials.getUsername(), credentials.getPassword()}
        };
    }
}
