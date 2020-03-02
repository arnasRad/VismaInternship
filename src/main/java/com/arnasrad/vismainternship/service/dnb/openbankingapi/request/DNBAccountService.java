package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.dto.account.AccountDto;
import com.arnasrad.vismainternship.model.dto.account.AccountDetailsDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.request.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DNBAccountService implements AccountService {

    @Override
    public List<AccountDto> getAccounts() throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getAccounts"));
    }

    @Override
    public AccountDto getAccount(String id) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getAccount"));
    }

    @Override
    public List<AccountDetailsDto> getAccountDetails(String id) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getAccountDetails"));
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
