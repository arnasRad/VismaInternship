package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.account.Account;
import com.arnasrad.vismainternship.model.account.AccountDetails;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.service.revolut.request.RevolutAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final RevolutAccountService revolutAccountService;

    @Autowired
    public AccountController(RevolutAccountService revolutAccountService) {

        this.revolutAccountService = revolutAccountService;
    }

    @GetMapping("/revolut/accounts")
    public List<? extends Account> getAccounts() throws BadRequestException {

        return revolutAccountService.getAccounts();
    }

    @GetMapping("/revolut/account")
    public Account getAccountById(@RequestParam String id) throws BadRequestException {

        return revolutAccountService.getAccount(id);
    }

    @GetMapping("/revolut/account-details")
    public List<? extends AccountDetails> getAccountDetails(@RequestParam String id) throws BadRequestException {

        return revolutAccountService.getAccountDetails(id);
    }
}
