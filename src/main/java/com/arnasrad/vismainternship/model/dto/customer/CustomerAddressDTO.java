package com.arnasrad.vismainternship.model.dto.customer;

public class CustomerAddressDTO {

    private String postalCode;
    private String addressLine1;

    public CustomerAddressDTO() {
    }

    public CustomerAddressDTO(String postalCode, String addressLine1) {
        this.postalCode = postalCode;
        this.addressLine1 = addressLine1;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
}