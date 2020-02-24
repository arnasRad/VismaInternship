package com.arnasrad.vismainternship.token;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DnbJwtToken {

    private String token;

    private DnbJwtToken(@Value("${dnb.jwtToken}") final String jwtToken) {

        this.token = jwtToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
