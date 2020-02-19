package com.arnasrad.vismainternship.model.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.customer.CustomerInfo;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNBCustomerInfo extends CustomerInfo {

    private String customerType;
    private Citizenship[] citizenship;
    private CountryTax[] countryTax;

    public DNBCustomerInfo() {
    }

    public DNBCustomerInfo(String customerId, String firstName, String lastName, DNBCustomerAddress DNBCustomerAddress, String phone,
                           String email, String countryOfBirth, String customerType, Citizenship[] citizenship,
                           CountryTax[] countryTax) {

        super(customerId, firstName, lastName, DNBCustomerAddress, phone, email, countryOfBirth);
        this.customerType = customerType;
        this.citizenship = citizenship;
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

    public CountryTax[] getCountryTax() {
        return countryTax;
    }

    public void setCountryTax(CountryTax[] countryTax) {
        this.countryTax = countryTax;
    }
}
