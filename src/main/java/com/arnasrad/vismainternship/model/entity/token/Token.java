package com.arnasrad.vismainternship.model.entity.token;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Token {

    @Id
    private String clientId;
    @Column(length = 800)
    private String token;
    private String tokenType;
    private Integer expiresId;
    private String customerPublicId;

    public Token() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public void setExpiresId(Integer expiresId) {
        this.expiresId = expiresId;
    }

    public void setExpiresId(int expiresId) {
        this.expiresId = expiresId;
    }

    public String getCustomerPublicId() {
        return customerPublicId;
    }

    public void setCustomerPublicId(String customerPublicId) {
        this.customerPublicId = customerPublicId;
    }
}
