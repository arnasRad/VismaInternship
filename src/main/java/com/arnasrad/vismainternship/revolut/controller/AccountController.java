package com.arnasrad.vismainternship.revolut.controller;

import com.arnasrad.vismainternship.revolut.model.account.Account;
import com.arnasrad.vismainternship.revolut.model.account.AccountDetails;
import com.arnasrad.vismainternship.revolut.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    @Qualifier("revolut-request-service")
    private RequestService requestService;

    @GetMapping("/")
    public String mainPage() {
        return "Welcome to Visma Open Banking API!";
    }

    @GetMapping("/revolut/accounts")
    public List<Account> getAccounts() {

        return requestService.getAccounts();
    }

    @GetMapping("/revolut/account")
    public Account getAccountById(String id) {

        return requestService.getAccount(id);
    }

    @GetMapping("/revolut/account-details")
    public List<AccountDetails> getAccountDetails(String id) {

        return requestService.getAccountDetails(id);
    }
}
