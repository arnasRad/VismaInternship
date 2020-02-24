package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceFactory {

    private List<AccountService> accountServiceList;

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
