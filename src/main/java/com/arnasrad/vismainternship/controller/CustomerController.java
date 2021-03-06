package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.dto.CustomerDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.CustomerServiceFactory;
import com.arnasrad.vismainternship.service.request.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("interbanking-customer-controller")
public class CustomerController {

    private final CustomerServiceFactory customerServiceFactory;

    public CustomerController(CustomerServiceFactory customerServiceFactory) {
        this.customerServiceFactory = customerServiceFactory;
    }

    @GetMapping("/interbanking/customers")
    public List<CustomerDto> getCustomers(@RequestParam String bank)
            throws NoSuchFunctionalityException {
        CustomerService service = customerServiceFactory.getService(bank);
        return service.getCustomers();
    }
}
