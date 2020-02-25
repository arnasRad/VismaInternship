package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.transaction.TransactionDTO;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.Date;
import java.util.List;

public interface TransactionService {
    TransactionDTO getTransaction(String id) throws NoSuchFunctionalityException;

    List<? extends TransactionDTO> getTransactions(String counterparty, Date from, Date to, Integer count) throws NoSuchFunctionalityException;

    String getBankId();
}
