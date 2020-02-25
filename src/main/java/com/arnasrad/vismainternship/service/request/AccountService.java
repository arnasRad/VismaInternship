package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.entity.account.Account;
import com.arnasrad.vismainternship.model.entity.account.AccountDetails;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface AccountService {

    List<? extends Account> getAccounts() throws NoSuchFunctionalityException;

    Account getAccount(String id) throws NoSuchFunctionalityException;

    List<? extends AccountDetails> getAccountDetails(String id) throws NoSuchFunctionalityException;

    String getBankId();
}
