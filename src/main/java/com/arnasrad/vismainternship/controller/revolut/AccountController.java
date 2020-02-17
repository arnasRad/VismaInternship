package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.Account;
import com.arnasrad.vismainternship.model.AccountDetails;
import com.arnasrad.vismainternship.service.revolut.request.RevolutAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final RevolutAccountService revolutAccountService;

    @Autowired
    public AccountController(RevolutAccountService revolutAccountService) {

        this.revolutAccountService = revolutAccountService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "Welcome to Visma Open Banking API!";
    }

    @GetMapping("/revolut/accounts")
    public List<? extends Account> getAccounts() {

        return revolutAccountService.getAccounts();
    }

    @GetMapping("/revolut/account")
    public Account getAccountById(String id) {

        return revolutAccountService.getAccount(id);
    }

    @GetMapping("/revolut/account-details")
    public List<? extends AccountDetails> getAccountDetails(String id) {

        return revolutAccountService.getAccountDetails(id);
    }
}
