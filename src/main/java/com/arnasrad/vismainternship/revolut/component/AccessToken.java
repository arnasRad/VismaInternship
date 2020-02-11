package com.arnasrad.vismainternship.revolut.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccessToken {

    private String token;

    @Autowired
    private AccessToken(@Value("${revolut.sandbox.constant.accesstoken}") final String accessToken) {

        this.token = accessToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
