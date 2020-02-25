package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyDTO;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CounterpartyService {

    CounterpartyDTO addCounterparty(String body) throws NoSuchFunctionalityException;

    List<? extends CounterpartyDTO> getCounterparties() throws NoSuchFunctionalityException;

    String deleteCounterparty(String id) throws NoSuchFunctionalityException;

    String getBankId();
}
