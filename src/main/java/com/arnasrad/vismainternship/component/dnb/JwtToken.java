package com.arnasrad.vismainternship.component.dnb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtToken {

    private String token;

    @Autowired
    private JwtToken(@Value("${dnb.jwtToken}") final String jwtToken) {

        this.token = jwtToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
