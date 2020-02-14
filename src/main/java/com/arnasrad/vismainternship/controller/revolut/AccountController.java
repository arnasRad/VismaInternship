package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.revolut.account.Account;
import com.arnasrad.vismainternship.model.revolut.account.AccountDetails;
import com.arnasrad.vismainternship.service.revolut.RevolutRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    @Qualifier("revolut-request-service")
    private RevolutRequestService revolutRequestService;

    @GetMapping("/")
    public String mainPage() {
        return "Welcome to Visma Open Banking API!";
    }

    @GetMapping("/revolut/accounts")
    public List<Account> getAccounts() {

        return revolutRequestService.getAccounts();
    }

    @GetMapping("/revolut/account")
    public Account getAccountById(String id) {

        return revolutRequestService.getAccount(id);
    }

    @GetMapping("/revolut/account-details")
    public List<AccountDetails> getAccountDetails(String id) {

        return revolutRequestService.getAccountDetails(id);
    }
}
