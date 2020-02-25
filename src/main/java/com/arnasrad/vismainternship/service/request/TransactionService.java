package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.entity.transaction.Transaction;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.Date;
import java.util.List;

public interface TransactionService {
    Transaction getTransaction(String id) throws NoSuchFunctionalityException;

    List<? extends Transaction> getTransactions(String counterparty, Date from, Date to, Integer count) throws NoSuchFunctionalityException;

    String getBankId();
}
