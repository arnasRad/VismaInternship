package com.arnasrad.vismainternship.dnb.openbanking.model.customer;

public class Customer {

    private String customerName;
    private String ssn;

    public Customer() {
    }

    public Customer(String customerName, String ssn) {
        this.customerName = customerName;
        this.ssn = ssn;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
