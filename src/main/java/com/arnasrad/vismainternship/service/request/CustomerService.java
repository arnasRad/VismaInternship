package com.arnasrad.vismainternship.service.request;


import com.arnasrad.vismainternship.model.entity.customer.Customer;
import com.arnasrad.vismainternship.model.entity.customer.CustomerInfo;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CustomerService {

    List<? extends Customer> getCustomers() throws NoSuchFunctionalityException;

    CustomerInfo getCurrentCustomerInfo() throws NoSuchFunctionalityException;

    CustomerInfo getCustomerInfo(String ssn) throws NoSuchFunctionalityException;

    String getBankId();
}
