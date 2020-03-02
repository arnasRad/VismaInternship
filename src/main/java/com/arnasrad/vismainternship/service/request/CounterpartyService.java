package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CounterpartyService {

    CounterpartyDto addCounterparty(String body) throws NoSuchFunctionalityException;

    List<? extends CounterpartyDto> getCounterparties() throws NoSuchFunctionalityException;

    String deleteCounterparty(String id) throws NoSuchFunctionalityException;

    String getBankId();
}
