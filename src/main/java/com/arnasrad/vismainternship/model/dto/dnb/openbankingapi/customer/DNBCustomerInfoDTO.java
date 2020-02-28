package com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.customer.CustomerInfoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNBCustomerInfoDTO extends CustomerInfoDTO {

    private String customerType;
    private List<CitizenshipDTO> citizenship;
    private List<CountryTaxDTO> countryTax;

    public DNBCustomerInfoDTO() {
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public List<CitizenshipDTO> getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(List<CitizenshipDTO> citizenship) {
        this.citizenship = citizenship;
    }

    public List<CountryTaxDTO> getCountryTax() {
        return countryTax;
    }

    public void setCountryTax(List<CountryTaxDTO> countryTax) {
        this.countryTax = countryTax;
    }
}
