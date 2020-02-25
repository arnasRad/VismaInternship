package com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CountryTax {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String taxLiabilityCountry;
    private String taxIdentificationNumber;

    public CountryTax() {
    }

    public CountryTax(String taxLiabilityCountry, String taxIdentificationNumber) {
        this.taxLiabilityCountry = taxLiabilityCountry;
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxLiabilityCountry() {
        return taxLiabilityCountry;
    }

    public void setTaxLiabilityCountry(String taxLiabilityCountry) {
        this.taxLiabilityCountry = taxLiabilityCountry;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }
}
