package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.dto.account.AccountDTO;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDTO;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDetailsDTO;
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
    public List<RevolutAccountDTO> getAccounts() {
        return revolutAccountService.getAccounts();
    }

    @GetMapping("/revolut/account")
    public AccountDTO getAccountById(@RequestParam String id) {
        return revolutAccountService.getAccount(id);
    }

    @GetMapping("/revolut/account-details")
    public List<RevolutAccountDetailsDTO> getAccountDetails(@RequestParam String id) {
        return revolutAccountService.getAccountDetails(id);
    }
}
