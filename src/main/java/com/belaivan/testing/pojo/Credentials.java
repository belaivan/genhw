package com.belaivan.testing.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }
}
