package com.arnasrad.vismainternship.model.dto.token;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RevolutTokenDTO {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_id")
    private int expiresId;

    public RevolutTokenDTO() {
    }

    public RevolutTokenDTO(String accessToken, String tokenType, int expiresId) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresId = expiresId;
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