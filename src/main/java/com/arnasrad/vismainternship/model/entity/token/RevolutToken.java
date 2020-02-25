package com.arnasrad.vismainternship.model.entity.token;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RevolutToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accessToken;
    private String tokenType;
    private int expiresId;

    public RevolutToken() {
    }

    public RevolutToken(String accessToken, String tokenType, int expiresId) {
        this.id = id;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresId = expiresId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getExpiresId() {
        return expiresId;
    }

    public void setExpiresId(int expiresId) {
        this.expiresId = expiresId;
    }
}
