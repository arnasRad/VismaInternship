package com.arnasrad.vismainternship.dnb.model;

public class CountryTax {

    private String taxLiabilityCountry;
    private String taxIdentificationNumber;

    public CountryTax() {
    }

    public CountryTax(String taxLiabilityCountry, String taxIdentificationNumber) {
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
