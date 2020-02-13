package com.arnasrad.vismainternship.interbankingapi.controller;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.interbankingapi.model.Customer;
import com.arnasrad.vismainternship.interbankingapi.service.RequestMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("interbanking-customer-controller")
public class CustomerController {

    @Autowired
    private OptionalValueProcessor optionalValueProcessor;

    @Autowired
    private RequestMappingService requestMappingService;

    @GetMapping("/interbanking/customers")
    public Map<String, List<Customer>> getCustomers(String bank) {

        return requestMappingService.mapCustomersRequest(optionalValueProcessor.getOptionalRequestParameterValue(
                "bank", bank));
    }
}
