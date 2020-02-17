package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.model.Account;
import com.arnasrad.vismainternship.service.RequestMappingService;
import com.arnasrad.vismainternship.service.factory.AccountFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("interbanking-account-controller")
public class AccountController {

    private final OptionalValueProcessor optionalValueProcessor;
    private final RequestMappingService requestMappingService;
    private final AccountFactory accountFactory;

    @Autowired
    public AccountController(OptionalValueProcessor optionalValueProcessor,
                             RequestMappingService requestMappingService, AccountFactory accountFactory) {

        this.optionalValueProcessor = optionalValueProcessor;
        this.requestMappingService = requestMappingService;
        this.accountFactory = accountFactory;
    }

    @GetMapping("/interbanking/accounts")
    public List<? extends Account> getAccounts(String bank) {

        return accountFactory.getService(bank).getAccounts();
//        return requestMappingService.mapAccountsRequest(optionalValueProcessor.getRequestParameterValue(
//                "bank", bank));
    }
}
