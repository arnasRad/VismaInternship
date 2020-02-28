package com.arnasrad.vismainternship.model.dto.token;

public class DNBTokenDTO {

    private String customerPublicId;
    private String jwtToken;
    private String clientId;

    public DNBTokenDTO() {
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
