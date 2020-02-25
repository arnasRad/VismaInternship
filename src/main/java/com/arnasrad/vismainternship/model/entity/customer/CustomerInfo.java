package com.arnasrad.vismainternship.model.entity.customer;

import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer.DNBCustomerAddress;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerInfo {

    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    @ManyToOne
    private Address address;
    private String phone;
    private String email;
    private String countryOfBirth;

    public CustomerInfo() {
    }

    public CustomerInfo(String customerId, String firstName, String lastName, DNBCustomerAddress address, String phone,
                        String email, String countryOfBirth) {

        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.countryOfBirth = countryOfBirth;
    }

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
