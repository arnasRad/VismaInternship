package com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.customer.CustomerInfoDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNBCustomerInfoDto extends CustomerInfoDto {

    private String customerType;
    private List<CitizenshipDto> citizenship;
    private List<CountryTaxDto> countryTax;

    public DNBCustomerInfoDto() {
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public List<CitizenshipDto> getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(List<CitizenshipDto> citizenship) {
        this.citizenship = citizenship;
    }

    public List<CountryTaxDto> getCountryTax() {
        return countryTax;
    }

    public void setCountryTax(List<CountryTaxDto> countryTax) {
        this.countryTax = countryTax;
    }
}
