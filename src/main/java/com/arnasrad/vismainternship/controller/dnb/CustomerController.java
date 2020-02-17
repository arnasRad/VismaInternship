package com.arnasrad.vismainternship.controller.dnb;

import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.Customer;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.CustomerInfo;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.DNBRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private DNBRequestService DnbRequestService;

    @GetMapping("/dnb/customers")
    public List<Customer> getTestCustomers() {

        return DnbRequestService.getCustomers();
    }

    @GetMapping("/dnb/current-customer-info")
    public CustomerInfo getCurrentCustomerInfo() {

        return DnbRequestService.getCurrentCustomerInfo();
    }

    @GetMapping("/dnb/customer-info")
    public CustomerInfo getCustomerInfo(String ssn) {

        return DnbRequestService.getCustomerInfo(ssn);
    }
}
