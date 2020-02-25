package com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.entity.customer.Customer;

import javax.persistence.Entity;

@Entity
public class DNBCustomer extends Customer {

    public DNBCustomer() {
    }

    public DNBCustomer(String customerName, String ssn) {
        super(customerName, ssn);
    }
}
