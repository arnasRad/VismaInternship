package com.arnasrad.vismainternship.controller.dnb;

import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer.DNBCustomer;
import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer.DNBCustomerInfo;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBCustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final DNBCustomerService dnbCustomerService;

    public CustomerController(DNBCustomerService dnbCustomerService) {
        this.dnbCustomerService = dnbCustomerService;
    }

    @GetMapping("/dnb/customers")
    public List<DNBCustomer> getTestCustomers() {
        return dnbCustomerService.getCustomers();
    }

    @GetMapping("/dnb/current-customer-info")
    public DNBCustomerInfo getCurrentCustomerInfo() {
        return dnbCustomerService.getCurrentCustomerInfo();
    }

    @GetMapping("/dnb/customer-info")
    public DNBCustomerInfo getCustomerInfo(String ssn) {
        return dnbCustomerService.getCustomerInfo(ssn);
    }
}
