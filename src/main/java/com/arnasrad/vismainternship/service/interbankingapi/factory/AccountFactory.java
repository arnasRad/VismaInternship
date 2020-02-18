package com.arnasrad.vismainternship.service.interbankingapi.factory;

import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBAccountService;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.AccountService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.arnasrad.vismainternship.model.enums.BankId.DNB_ID;
import static com.arnasrad.vismainternship.model.enums.BankId.REVOLUT_ID;

@Component
public class AccountFactory {

    private final RevolutAccountService revolutAccountService;
    private final DNBAccountService dnbAccountService;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public AccountFactory(RevolutAccountService revolutAccountService, DNBAccountService dnbAccountService,
                          ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.revolutAccountService = revolutAccountService;
        this.dnbAccountService = dnbAccountService;
        this.exceptionBuilder = exceptionBuilder;
    }

    public AccountService getService(String bank) {

        switch (bank) {
            case REVOLUT_ID:
                return revolutAccountService;
            case DNB_ID:
                return dnbAccountService;
            default:
                throw exceptionBuilder.getWrongBankException400();
        }
    }
}
