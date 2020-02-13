package com.arnasrad.vismainternship.interbankingapi.model;

import com.arnasrad.vismainternship.dnb.openbanking.model.customer.Address;

public class CustomerInfo {

    private String firstName;
    private String lastName;
    private Address address;
    private String phone;
    private String email;
    private String countryOfBirth;

    public CustomerInfo() {
    }

    public CustomerInfo(String firstName, String lastName, Address address, String phone, String email, String countryOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.countryOfBirth = countryOfBirth;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
}
