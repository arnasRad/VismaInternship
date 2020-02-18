package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.CounterpartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CounterpartyServiceFactory {

    private List<CounterpartyService> counterpartyServiceList;

    @Autowired
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
