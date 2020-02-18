package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;

import java.util.List;

public interface CounterpartyService {

    Counterparty addCounterparty(CounterpartyRequestBody body) throws NoSuchFunctionalityException, BadRequestException;

    List<? extends Counterparty> getCounterparties() throws NoSuchFunctionalityException, BadRequestException;

    String getBankId();
}
