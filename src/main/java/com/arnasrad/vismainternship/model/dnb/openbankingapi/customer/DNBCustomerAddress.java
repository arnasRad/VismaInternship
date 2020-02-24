package com.arnasrad.vismainternship.model.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.customer.Address;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNBCustomerAddress extends Address {
    private String postalAddressCountry;
    private String postalCodeName;
    private String addressLine2;
    private String addressLine3;

    public DNBCustomerAddress() {
    }

    public DNBCustomerAddress(String postalCode, String addressLine1, String postalAddressCountry,
                              String postalCodeName, String addressLine2, String addressLine3) {
        super(postalCode, addressLine1);
        this.postalAddressCountry = postalAddressCountry;
        this.postalCodeName = postalCodeName;
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
