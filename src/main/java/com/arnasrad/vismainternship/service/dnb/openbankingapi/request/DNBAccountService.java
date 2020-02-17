package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.Account;
import com.arnasrad.vismainternship.model.AccountDetails;
import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.request.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DNBAccountService implements AccountService {

    @Value("${constant.dnb-id-uppercase}")
    private String dnbId;

    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public DNBAccountService(ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public List<Account> getAccounts() {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "getAccounts");
    }

    @Override
    public Account getAccount(String id) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "getAccount");
    }

    @Override
    public List<AccountDetails> getAccountDetails(String id) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "getAccountDetails");
    }
}
