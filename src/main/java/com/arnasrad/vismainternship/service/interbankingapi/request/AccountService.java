package com.arnasrad.vismainternship.service.interbankingapi.request;

import com.arnasrad.vismainternship.model.interbankingapi.account.Account;
import com.arnasrad.vismainternship.model.interbankingapi.account.AccountDetails;

import java.util.List;

public interface AccountService {

    List<? extends Account> getAccounts();

    Account getAccount(String id);

    List<? extends AccountDetails> getAccountDetails(String id);
}
