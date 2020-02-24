package com.arnasrad.vismainternship.token;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RevolutAccessToken {
    private String token;

    private RevolutAccessToken(@Value("${revolut.sandbox.constant.accessToken}") final String accessToken) {
        this.token = accessToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
