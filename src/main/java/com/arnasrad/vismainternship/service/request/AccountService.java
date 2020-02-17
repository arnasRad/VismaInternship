package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.Account;
import com.arnasrad.vismainternship.model.AccountDetails;

import java.util.List;

public interface AccountService {

    List<? extends Account> getAccounts();

    Account getAccount(String id);

    List<? extends AccountDetails> getAccountDetails(String id);
}
