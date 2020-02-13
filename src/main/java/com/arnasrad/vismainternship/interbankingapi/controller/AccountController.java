package com.arnasrad.vismainternship.interbankingapi.controller;

import com.arnasrad.vismainternship.interbankingapi.model.Account;
import com.arnasrad.vismainternship.interbankingapi.service.RequestMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController("interbanking-account-controller")
public class AccountController {

    @Value("${error.msg.invalid-parameters}")
    private String invalidParametersError;

    @Value("${error.msg.specify-bank}")
    private String specifyBankErrorMsg;

    @Autowired
    private RequestMappingService requestMappingService;

    @GetMapping("/interbanking/accounts")
    public Map<String, List<Account>> getAccounts(String bank) {

        String bankId = Optional.ofNullable(bank).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                invalidParametersError.concat(specifyBankErrorMsg)));
        return requestMappingService.mapAccountsRequest(bankId);
    }
}
