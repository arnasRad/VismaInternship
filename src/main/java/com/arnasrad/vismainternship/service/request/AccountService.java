package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.account.Account;
import com.arnasrad.vismainternship.model.account.AccountDetails;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface AccountService {

    List<? extends Account> getAccounts() throws NoSuchFunctionalityException, BadRequestException;

    Account getAccount(String id) throws NoSuchFunctionalityException, BadRequestException;

    List<? extends AccountDetails> getAccountDetails(String id) throws NoSuchFunctionalityException, BadRequestException;

    String getBankId();
}
