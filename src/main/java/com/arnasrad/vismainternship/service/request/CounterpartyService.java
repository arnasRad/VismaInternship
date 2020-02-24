package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CounterpartyService {

    Counterparty addCounterparty(String body) throws NoSuchFunctionalityException;

    List<? extends Counterparty> getCounterparties() throws NoSuchFunctionalityException;

    String deleteCounterparty(String id) throws NoSuchFunctionalityException;

    String getBankId();
}
