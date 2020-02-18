package com.arnasrad.vismainternship.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RevolutAccessToken {

    private String token;

    @Autowired
    private RevolutAccessToken(@Value("${revolut.sandbox.constant.accesstoken}") final String accessToken) {

        this.token = accessToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
