package com.arnasrad.vismainternship.controller.dnb;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerInfoDTO;
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
    public List<DNBCustomerDTO> getTestCustomers() {
        return dnbCustomerService.getCustomers();
    }

    @GetMapping("/dnb/current-customer-info")
    public DNBCustomerInfoDTO getCurrentCustomerInfo() {
        return dnbCustomerService.getCurrentCustomerInfo();
    }

    @GetMapping("/dnb/customer-info")
    public DNBCustomerInfoDTO getCustomerInfo(String ssn) {
        return dnbCustomerService.getCustomerInfo(ssn);
    }
}
