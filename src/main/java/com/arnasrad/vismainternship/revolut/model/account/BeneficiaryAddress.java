package com.arnasrad.vismainternship.revolut.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeneficiaryAddress {

    @JsonProperty("street_line1")
    private String streetLine1;

    @JsonProperty("street_line1")
    private String streetLine2;

    private String region;
    private String city;
    private String country;
    private String postcode;

    public BeneficiaryAddress() {
    }

    public BeneficiaryAddress(String streetLine1, String streetLine2, String region, String city, String country, String postcode) {
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.region = region;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
