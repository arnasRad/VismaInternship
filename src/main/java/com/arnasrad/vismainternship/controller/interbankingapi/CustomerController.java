package com.arnasrad.vismainternship.controller.interbankingapi;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.model.interbankingapi.customer.Customer;
import com.arnasrad.vismainternship.service.interbankingapi.factory.CustomerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("interbanking-customer-controller")
public class CustomerController {

    private final OptionalValueProcessor optionalValueProcessor;
    private final CustomerFactory customerFactory;

    @Autowired
    public CustomerController(OptionalValueProcessor optionalValueProcessor, CustomerFactory customerFactory) {
        this.optionalValueProcessor = optionalValueProcessor;
        this.customerFactory = customerFactory;
    }

    @GetMapping("/interbanking/customers")
    public List<? extends Customer> getCustomers(String bank) {

        return customerFactory.getService(optionalValueProcessor.getRequestParameterValue("bank", bank)).getCustomers();
    }
}
