package com.arnasrad.vismainternship.model.entity.token;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private String tokenType;
    private Integer expiresId;
    private String customerPublicId;

    public Token() {
    }

    public Token(String token, String tokenType, Integer expiresId, String customerPublicId) {
        this.token = token;
        this.tokenType = tokenType;
        this.expiresId = expiresId;
        this.customerPublicId = customerPublicId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
