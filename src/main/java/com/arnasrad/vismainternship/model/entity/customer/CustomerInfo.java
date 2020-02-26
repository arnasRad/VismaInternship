package com.arnasrad.vismainternship.model.entity.customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    private String firstName;
    private String lastName;
    @ManyToOne
    private CustomerAddress address;
    private String phone;
    private String email;
    private String countryOfBirth;
    private String customerType;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Citizenship> citizenship;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CountryTax> countryTax;

    public CustomerInfo() {
    }

    public CustomerInfo(String customerId, String firstName, String lastName, CustomerAddress address, String phone,
                        String email, String countryOfBirth, String customerType, List<Citizenship> citizenship,
                        List<CountryTax> countryTax) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.countryOfBirth = countryOfBirth;
        this.customerType = customerType;
        this.citizenship = citizenship;
        this.countryTax = countryTax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CustomerAddress getAddress() {
        return address;
    }

    public void setAddress(CustomerAddress address) {
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

    public List<Citizenship> getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(List<Citizenship> citizenship) {
        this.citizenship = citizenship;
    }

    public List<CountryTax> getCountryTax() {
        return countryTax;
    }

    public void setCountryTax(List<CountryTax> countryTax) {
        this.countryTax = countryTax;
    }
}