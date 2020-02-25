package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.account.AccountDTO;
import com.arnasrad.vismainternship.model.dto.account.AccountDetailsDTO;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface AccountService {

    List<? extends AccountDTO> getAccounts() throws NoSuchFunctionalityException;

    AccountDTO getAccount(String id) throws NoSuchFunctionalityException;

    List<? extends AccountDetailsDTO> getAccountDetails(String id) throws NoSuchFunctionalityException;

    String getBankId();
}
