package com.arnasrad.vismainternship.service.request;


import com.arnasrad.vismainternship.model.customer.Customer;
import com.arnasrad.vismainternship.model.customer.CustomerInfo;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CustomerService {

    List<? extends Customer> getCustomers() throws NoSuchFunctionalityException, BadRequestException;

    CustomerInfo getCurrentCustomerInfo() throws NoSuchFunctionalityException, BadRequestException;

    CustomerInfo getCustomerInfo(String ssn) throws NoSuchFunctionalityException, BadRequestException;

    String getBankId();
}
