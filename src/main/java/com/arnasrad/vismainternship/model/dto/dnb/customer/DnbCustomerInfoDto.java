package com.arnasrad.vismainternship.model.dto.dnb.customer;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbCustomerInfoDto {

    private String customerId;
    private String firstName;
    private String lastName;
    private CustomerAddressDto address;
    private String phone;
    private String email;
    private String countryOfBirth;
    private String customerType;
    private List<CitizenshipDto> citizenship;
    private List<CountryTaxDto> countryTax;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerAddressDto getAddress() {
        return address;
    }

    public void setAddress(CustomerAddressDto address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
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
