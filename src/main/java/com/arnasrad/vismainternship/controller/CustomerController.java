package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.customer.Customer;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.CustomerServiceFactory;
import com.arnasrad.vismainternship.service.processor.OptionalValueProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("interbanking-customer-controller")
public class CustomerController {

    private final OptionalValueProcessorService optionalValueProcessorService;
    private final CustomerServiceFactory customerServiceFactory;

    @Autowired
    public CustomerController(OptionalValueProcessorService optionalValueProcessorService, CustomerServiceFactory customerServiceFactory) {
        this.optionalValueProcessorService = optionalValueProcessorService;
        this.customerServiceFactory = customerServiceFactory;
    }

    @GetMapping("/interbanking/customers")
    public List<? extends Customer> getCustomers(@RequestParam String bank) throws BadRequestException, NoSuchFunctionalityException {

        return customerServiceFactory.getService(optionalValueProcessorService.getRequestParameterValue("bank", bank)).getCustomers();
    }
}
