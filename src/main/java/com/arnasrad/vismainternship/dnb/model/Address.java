package com.arnasrad.vismainternship.dnb.model;

public class Address {

    private String postalAddressCountry;
    private String postalCodeName;
    private String postalCode;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;

    public Address() {
    }

    public Address(String postalAddressCountry, String postalCodeName, String postalCode, String addressLine1, String addressLine2, String addressLine3) {
        this.postalAddressCountry = postalAddressCountry;
        this.postalCodeName = postalCodeName;
        this.postalCode = postalCode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
    }

    public String getPostalAddressCountry() {
        return postalAddressCountry;
    }

    public void setPostalAddressCountry(String postalAddressCountry) {
        this.postalAddressCountry = postalAddressCountry;
    }

    public String getPostalCodeName() {
        return postalCodeName;
    }

    public void setPostalCodeName(String postalCodeName) {
        this.postalCodeName = postalCodeName;
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

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }
}
