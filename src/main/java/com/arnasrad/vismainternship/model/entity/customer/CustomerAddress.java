package com.arnasrad.vismainternship.model.entity.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postalCode;
    private String postalAddressCountry;
    private String postalCodeName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;

    public CustomerAddress() {
    }

    public CustomerAddress(String postalCode, String postalAddressCountry, String postalCodeName, String addressLine1, String addressLine2, String addressLine3) {
        this.postalCode = postalCode;
        this.postalAddressCountry = postalAddressCountry;
        this.postalCodeName = postalCodeName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
