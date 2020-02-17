package com.arnasrad.vismainternship.controller.dnb;

import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.Customer;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.CustomerInfo;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final DNBCustomerService DnbCustomerService;

    @Autowired
    public CustomerController(DNBCustomerService dnbCustomerService) {
        DnbCustomerService = dnbCustomerService;
    }

    @GetMapping("/dnb/customers")
    public List<Customer> getTestCustomers() {

        return DnbCustomerService.getCustomers();
    }

    @GetMapping("/dnb/current-customer-info")
    public CustomerInfo getCurrentCustomerInfo() {

        return DnbCustomerService.getCurrentCustomerInfo();
    }

    @GetMapping("/dnb/customer-info")
    public CustomerInfo getCustomerInfo(String ssn) {

        return DnbCustomerService.getCustomerInfo(ssn);
    }
}
