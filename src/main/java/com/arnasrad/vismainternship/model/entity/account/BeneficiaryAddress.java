package com.arnasrad.vismainternship.model.entity.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BeneficiaryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetLine1;
    private String streetLine2;
    private String region;
    private String city;
    private String country;
    private String postcode;

    public BeneficiaryAddress() {
    }

    public BeneficiaryAddress(String streetLine1, String streetLine2, String region, String city,
                              String country, String postcode) {
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.region = region;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
