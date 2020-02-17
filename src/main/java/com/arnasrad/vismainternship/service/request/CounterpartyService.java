package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.Counterparty;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;

import java.util.List;

public interface CounterpartyService {

    Counterparty addCounterparty(CounterpartyRequestBody body);

    List<? extends Counterparty> getCounterparties();
}
