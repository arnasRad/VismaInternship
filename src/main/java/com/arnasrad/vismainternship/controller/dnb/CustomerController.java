package com.arnasrad.vismainternship.controller.dnb;

import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.DNBCustomer;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.customer.DNBCustomerInfo;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final DNBCustomerService dnbCustomerService;

    @Autowired
    public CustomerController(DNBCustomerService dnbCustomerService) {
        this.dnbCustomerService = dnbCustomerService;
    }

    @GetMapping("/dnb/customers")
    public List<DNBCustomer> getTestCustomers() throws BadRequestException {

        return dnbCustomerService.getCustomers();
    }

    @GetMapping("/dnb/current-customer-info")
    public DNBCustomerInfo getCurrentCustomerInfo() throws BadRequestException {

        return dnbCustomerService.getCurrentCustomerInfo();
    }

    @GetMapping("/dnb/customer-info")
    public DNBCustomerInfo getCustomerInfo(String ssn) throws BadRequestException {

        return dnbCustomerService.getCustomerInfo(ssn);
    }
}
