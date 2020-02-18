package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountServiceFactory {

    private List<AccountService> accountServiceList;

    @Autowired
    public AccountServiceFactory(List<AccountService> accountServiceList) {

        this.accountServiceList = accountServiceList;
    }

    public AccountService getService(String bank) {

        return accountServiceList.stream()
                .filter(accountService -> accountService.getBankId().equals(bank))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ErrorMessages.WRONG_BANK));
    }
}
