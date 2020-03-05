package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.dto.AccountDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.AccountServiceFactory;
import com.arnasrad.vismainternship.service.request.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("interbanking-account-controller")
public class AccountController {

    private final AccountServiceFactory accountServiceFactory;

    public AccountController(AccountServiceFactory accountServiceFactory) {
        this.accountServiceFactory = accountServiceFactory;
    }

    @GetMapping("/interbanking/accounts")
    public List<AccountDto> getAccounts(@RequestParam String bank)
            throws NoSuchFunctionalityException {
        AccountService service = accountServiceFactory.getService(bank);
        return service.getAccounts();
    }
}
