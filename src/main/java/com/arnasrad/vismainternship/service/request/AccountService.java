package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.AccountDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAccounts() throws NoSuchFunctionalityException;

    AccountDto getAccount(String iban) throws NoSuchFunctionalityException;

    String getBankId();
}
