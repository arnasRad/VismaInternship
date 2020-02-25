package com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.customer.CustomerInfoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNBCustomerInfoDTO extends CustomerInfoDTO {
    private String customerType;
    private CitizenshipDTO[] citizenship;
    private CountryTaxDTO[] countryTax;

    public DNBCustomerInfoDTO() {
    }

    public DNBCustomerInfoDTO(String customerId, String firstName, String lastName,
                              DNBCustomerAddressDTO dnbCustomerAddress, String phone, String email,
                              String countryOfBirth, String customerType, CitizenshipDTO[] citizenship,
                              CountryTaxDTO[] countryTax) {
        super(customerId, firstName, lastName, dnbCustomerAddress, phone, email, countryOfBirth);
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

    public CitizenshipDTO[] getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(CitizenshipDTO[] citizenship) {
        this.citizenship = citizenship;
    }

    public CountryTaxDTO[] getCountryTax() {
        return countryTax;
    }

    public void setCountryTax(CountryTaxDTO[] countryTax) {
        this.countryTax = countryTax;
    }
}
