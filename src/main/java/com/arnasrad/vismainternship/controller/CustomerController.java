package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.model.Customer;
import com.arnasrad.vismainternship.service.RequestMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("interbanking-customer-controller")
public class CustomerController {

    private final OptionalValueProcessor optionalValueProcessor;
    private final RequestMappingService requestMappingService;

    @Autowired
    public CustomerController(OptionalValueProcessor optionalValueProcessor, RequestMappingService requestMappingService) {
        this.optionalValueProcessor = optionalValueProcessor;
        this.requestMappingService = requestMappingService;
    }

    @GetMapping("/interbanking/customers")
    public Map<String, List<Customer>> getCustomers(String bank) {

        return requestMappingService.mapCustomersRequest(optionalValueProcessor.getRequestParameterValue(
                "bank", bank));
    }
}
