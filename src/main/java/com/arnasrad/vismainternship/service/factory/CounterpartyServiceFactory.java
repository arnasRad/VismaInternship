package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.CounterpartyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterpartyServiceFactory {

    private List<CounterpartyService> counterpartyServiceList;

    public CounterpartyServiceFactory(List<CounterpartyService> counterpartyServiceList) {
        this.counterpartyServiceList = counterpartyServiceList;
    }

    public CounterpartyService getService(String bank) {
        return counterpartyServiceList.stream()
                .filter(counterpartyService -> counterpartyService.getBankId().equals(bank))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ErrorMessages.WRONG_BANK));
    }
}
