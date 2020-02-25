package com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryTaxDTO {
    private String taxLiabilityCountry;
    private String taxIdentificationNumber;

    public CountryTaxDTO() {
    }

    public CountryTaxDTO(String taxLiabilityCountry, String taxIdentificationNumber) {
        this.taxLiabilityCountry = taxLiabilityCountry;
        this.taxIdentificationNumber = taxIdentificationNumber;
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
