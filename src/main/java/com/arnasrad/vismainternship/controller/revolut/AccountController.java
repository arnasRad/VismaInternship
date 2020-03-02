package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.dto.account.AccountDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDetailsDto;
import com.arnasrad.vismainternship.service.revolut.request.RevolutAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final RevolutAccountService revolutAccountService;

    public AccountController(RevolutAccountService revolutAccountService) {
        this.revolutAccountService = revolutAccountService;
    }

    @GetMapping("/revolut/accounts")
    public List<RevolutAccountDto> getAccounts() {
        return revolutAccountService.getAccounts();
    }

    @GetMapping("/revolut/account")
    public AccountDto getAccountById(@RequestParam String id) {
        return revolutAccountService.getAccount(id);
    }

    @GetMapping("/revolut/account-details")
    public List<RevolutAccountDetailsDto> getAccountDetails(@RequestParam String id) {
        return revolutAccountService.getAccountDetails(id);
    }
}
