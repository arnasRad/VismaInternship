package com.arnasrad.vismainternship.dnb.controller;

import com.arnasrad.vismainternship.dnb.openbanking.model.customer.Customer;
import com.arnasrad.vismainternship.dnb.openbanking.model.customer.CustomerInfo;
import com.arnasrad.vismainternship.dnb.openbanking.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    @Qualifier("dnb-request-service")
    private RequestService requestService;

    @GetMapping("/dnb/customers")
    public List<Customer> getTestCustomers() {

        return requestService.getCustomers();
    }

    @GetMapping("/dnb/current-customer-info")
    public CustomerInfo getCurrentCustomerInfo() {

        return requestService.getCurrentCustomerInfo();
    }

    @GetMapping("/dnb/customer-info")
    public CustomerInfo getCustomerInfo(String ssn) {

        return requestService.getCustomerInfo(ssn);
    }
}
