package com.arnasrad.vismainternship.model.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.CustomerInfo;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNBCustomerInfo extends CustomerInfo {

    private String customerType;
    private Citizenship[] citizenship;
    private String customerId;
    private CountryTax[] countryTax;

    public DNBCustomerInfo() {
    }

    public DNBCustomerInfo(String firstName, String lastName, Address address, String phone, String email,
                           String countryOfBirth, String customerType, Citizenship[] citizenship, String customerId,
                           CountryTax[] countryTax) {

        super(firstName, lastName, address, phone, email, countryOfBirth);
        this.customerType = customerType;
        this.citizenship = citizenship;
        this.customerId = customerId;
        this.countryTax = countryTax;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Citizenship[] getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship[] citizenship) {
        this.citizenship = citizenship;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CountryTax[] getCountryTax() {
        return countryTax;
    }

    public void setCountryTax(CountryTax[] countryTax) {
        this.countryTax = countryTax;
    }
}
