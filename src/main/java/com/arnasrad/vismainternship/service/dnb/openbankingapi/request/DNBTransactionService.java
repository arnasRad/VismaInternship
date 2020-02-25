package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.entity.transaction.Transaction;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.request.TransactionService;

import java.util.Date;
import java.util.List;

public class DNBTransactionService implements TransactionService {

    @Override
    public Transaction getTransaction(String id) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getTransaction"));
    }

    @Override
    public List<? extends Transaction> getTransactions(String counterparty, Date from, Date to, Integer count)
            throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getTransactions"));
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
