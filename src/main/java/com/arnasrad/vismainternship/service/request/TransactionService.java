package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.TransactionDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.Date;
import java.util.List;

public interface TransactionService {
    TransactionDto getTransaction(String id) throws NoSuchFunctionalityException;

    List<TransactionDto> getTransactions(String counterparty, Date from, Date to, Integer count) throws NoSuchFunctionalityException;

    String getBankId();
}
