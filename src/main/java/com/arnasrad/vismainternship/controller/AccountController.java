package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.model.Account;
import com.arnasrad.vismainternship.service.factory.AccountFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("interbanking-account-controller")
public class AccountController {

    private final OptionalValueProcessor optionalValueProcessor;
    private final AccountFactory accountFactory;

    @Autowired
    public AccountController(OptionalValueProcessor optionalValueProcessor, AccountFactory accountFactory) {

        this.optionalValueProcessor = optionalValueProcessor;
        this.accountFactory = accountFactory;
    }

    @GetMapping("/interbanking/accounts")
    public List<? extends Account> getAccounts(String bank) {

        return accountFactory.getService(optionalValueProcessor.getRequestParameterValue("bank", bank)).getAccounts();
    }
}
