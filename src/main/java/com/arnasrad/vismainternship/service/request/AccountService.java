package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.account.AccountDto;
import com.arnasrad.vismainternship.model.dto.account.AccountDetailsDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface AccountService {

    List<? extends AccountDto> getAccounts() throws NoSuchFunctionalityException;

    AccountDto getAccount(String id) throws NoSuchFunctionalityException;

    List<? extends AccountDetailsDto> getAccountDetails(String id) throws NoSuchFunctionalityException;

    String getBankId();
}
