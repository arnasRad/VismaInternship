package com.arnasrad.vismainternship.service.request;


import com.arnasrad.vismainternship.model.dto.customer.CustomerDto;
import com.arnasrad.vismainternship.model.dto.customer.CustomerInfoDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CustomerService {

    List<? extends CustomerDto> getCustomers() throws NoSuchFunctionalityException;

    CustomerInfoDto getCurrentCustomerInfo() throws NoSuchFunctionalityException;

    CustomerInfoDto getCustomerInfo(String ssn) throws NoSuchFunctionalityException;

    String getBankId();
}
