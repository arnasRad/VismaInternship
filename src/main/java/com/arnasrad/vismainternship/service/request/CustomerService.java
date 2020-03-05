package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.CustomerDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getCustomers() throws NoSuchFunctionalityException;

    String getBankId();
}
