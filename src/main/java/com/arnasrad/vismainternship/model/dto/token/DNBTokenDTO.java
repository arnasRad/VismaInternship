package com.arnasrad.vismainternship.model.dto.token;

public class DNBTokenDTO {

    private String customerPublicId;
    private String jwtToken;

    public DNBTokenDTO() {
    }

    public DNBTokenDTO(String customerPublicId, String jwtToken) {
        this.customerPublicId = customerPublicId;
        this.jwtToken = jwtToken;
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
