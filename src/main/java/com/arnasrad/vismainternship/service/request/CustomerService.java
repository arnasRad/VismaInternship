package com.arnasrad.vismainternship.service.request;


import com.arnasrad.vismainternship.model.dto.customer.CustomerDTO;
import com.arnasrad.vismainternship.model.dto.customer.CustomerInfoDTO;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CustomerService {

    List<? extends CustomerDTO> getCustomers() throws NoSuchFunctionalityException;

    CustomerInfoDTO getCurrentCustomerInfo() throws NoSuchFunctionalityException;

    CustomerInfoDTO getCustomerInfo(String ssn) throws NoSuchFunctionalityException;

    String getBankId();
}
