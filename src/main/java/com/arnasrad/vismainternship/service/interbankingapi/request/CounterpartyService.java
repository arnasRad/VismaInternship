package com.arnasrad.vismainternship.service.interbankingapi.request;

import com.arnasrad.vismainternship.model.interbankingapi.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;

import java.util.List;

public interface CounterpartyService {

    Counterparty addCounterparty(CounterpartyRequestBody body);

    List<? extends Counterparty> getCounterparties();
}
