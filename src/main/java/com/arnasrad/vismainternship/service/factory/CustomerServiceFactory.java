package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceFactory {

    List<CustomerService> customerServiceList;

    @Autowired
    public CustomerServiceFactory(List<CustomerService> customerServiceList) {

        this.customerServiceList = customerServiceList;
    }

    public CustomerService getService(String bank) {

        return customerServiceList.stream()
                .filter(customerService -> customerService.getBankId().equals(bank))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ErrorMessages.WRONG_BANK));
    }
}
