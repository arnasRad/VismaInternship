package com.arnasrad.vismainternship.model.entity.customer;

import javax.persistence.*;

@Entity
public class CountryTax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taxLiabilityCountry;
    private String taxIdentificationNumber;
    @ManyToOne
    private CustomerInfo customerInfo;

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

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }
}
