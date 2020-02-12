package com.arnasrad.vismainternship.dnb.openbanking.model;

public class CustomerInfo {

    private String firstName;
    private String lastName;
    private String customerType;
    private Address address;
    private String phone;
    private String countryOfBirth;
    private Citizenship[] citizenship;
    private String customerId;
    private String email;
    private CountryTax[] countryTax;

    public CustomerInfo() {
    }

    public CustomerInfo(String firstName, String lastName,
                        String customerType, Address address,
                        String phone, String countryOfBirth,
                        Citizenship[] citizenship, String customerId,
                        String email, CountryTax[] countryTax) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerType = customerType;
        this.address = address;
        this.phone = phone;
        this.countryOfBirth = countryOfBirth;
        this.citizenship = citizenship;
        this.customerId = customerId;
        this.email = email;
        this.countryTax = countryTax;
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

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CountryTax[] getCountryTax() {
        return countryTax;
    }

    public void setCountryTax(CountryTax[] countryTax) {
        this.countryTax = countryTax;
    }
}
