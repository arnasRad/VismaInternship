package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.interbankingapi.customer.Customer;
import com.arnasrad.vismainternship.model.interbankingapi.customer.CustomerInfo;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevolutCustomerService implements CustomerService {

    @Value("${constant.revolut-id-uppercase}")
    private String revolutId;

    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public RevolutCustomerService(ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public List<Customer> getCustomers() {

        throw exceptionBuilder.getNoFunctionalityException400(revolutId, "getCustomers");
    }

    @Override
    public CustomerInfo getCurrentCustomerInfo() {

        throw exceptionBuilder.getNoFunctionalityException400(revolutId, "getCurrentCustomerInfo");
    }

    @Override
    public CustomerInfo getCustomerInfo(String ssn) {

        throw exceptionBuilder.getNoFunctionalityException400(revolutId, "getCustomerInfo");
    }
}
