package com.arnasrad.vismainternship.model.entity.token;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DNBToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerPublicId;
    private String jwtToken;

    public DNBToken() {
    }

    public DNBToken(String customerPublicId, String jwtToken) {
        this.customerPublicId = customerPublicId;
        this.jwtToken = jwtToken;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerPublicId() {
        return customerPublicId;
    }

    public void setCustomerPublicId(String customerPublicId) {
        this.customerPublicId = customerPublicId;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
