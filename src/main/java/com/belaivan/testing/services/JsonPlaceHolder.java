package com.belaivan.testing.services;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class JsonPlaceHolder {

    OkHttpClient client = new OkHttpClient();

    public Response getUsers() throws IOException {
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/users")
                .get()
                .build();
        Call call = client.newCall(request);
        return call.execute();
    }
}
