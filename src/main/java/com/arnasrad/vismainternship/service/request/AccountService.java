package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.revolut.account.Account;
import com.arnasrad.vismainternship.model.revolut.account.AccountDetails;

import java.util.List;

public interface AccountService {

    List<Account> getAccounts();

    Account getAccount(String id);

    List<AccountDetails> getAccountDetails(String id);
}
