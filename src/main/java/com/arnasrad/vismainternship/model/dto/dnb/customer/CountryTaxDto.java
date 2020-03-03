package com.arnasrad.vismainternship.model.dto.dnb.customer;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryTaxDto {

    private String taxLiabilityCountry;
    private String taxIdentificationNumber;

    public CountryTaxDto() {
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
