package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.revolut.counterparty.AddCounterparty;
import com.arnasrad.vismainternship.model.revolut.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;

import java.util.List;

public interface CounterpartyService {

    AddCounterparty addCounterparty(CounterpartyRequestBody body);

    List<Counterparty> getCounterparties();
}
