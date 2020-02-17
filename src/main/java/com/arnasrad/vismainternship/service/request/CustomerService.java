package com.arnasrad.vismainternship.service.request;


import com.arnasrad.vismainternship.model.Customer;
import com.arnasrad.vismainternship.model.CustomerInfo;

import java.util.List;

public interface CustomerService {

    List<? extends Customer> getCustomers();

    CustomerInfo getCurrentCustomerInfo();

    CustomerInfo getCustomerInfo(String ssn);
}
