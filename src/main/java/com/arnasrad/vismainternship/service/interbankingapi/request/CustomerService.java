package com.arnasrad.vismainternship.service.interbankingapi.request;


import com.arnasrad.vismainternship.model.interbankingapi.customer.Customer;
import com.arnasrad.vismainternship.model.interbankingapi.customer.CustomerInfo;

import java.util.List;

public interface CustomerService {

    List<? extends Customer> getCustomers();

    CustomerInfo getCurrentCustomerInfo();

    CustomerInfo getCustomerInfo(String ssn);
}
