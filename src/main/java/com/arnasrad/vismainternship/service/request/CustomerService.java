package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.Customer;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.CustomerInfo;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    CustomerInfo getCurrentCustomerInfo();

    CustomerInfo getCustomerInfo(String ssn);
}
