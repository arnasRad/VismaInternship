package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.model.Account;
import com.arnasrad.vismainternship.service.RequestMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("interbanking-account-controller")
public class AccountController {

    @Autowired
    private OptionalValueProcessor optionalValueProcessor;

    @Autowired
    private RequestMappingService requestMappingService;

    @GetMapping("/interbanking/accounts")
    public Map<String, List<Account>> getAccounts(String bank) {

        return requestMappingService.mapAccountsRequest(optionalValueProcessor.getRequestParameterValue(
                "bank", bank));
    }
}
