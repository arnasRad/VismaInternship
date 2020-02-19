package com.arnasrad.vismainternship.model.customer;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    @Id
    private String ssn;
    private String customerName;

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
