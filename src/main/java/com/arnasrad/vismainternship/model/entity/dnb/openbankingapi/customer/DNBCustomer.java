package com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.entity.customer.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNBCustomer extends Customer {

    public DNBCustomer() {
    }

    public DNBCustomer(String customerName, String ssn) {
        super(customerName, ssn);
    }
}
