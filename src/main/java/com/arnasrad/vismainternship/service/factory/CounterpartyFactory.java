package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBCounterpartyService;
import com.arnasrad.vismainternship.service.request.CounterpartyService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutCounterpartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.arnasrad.vismainternship.enums.BankId.DNB_ID;
import static com.arnasrad.vismainternship.enums.BankId.REVOLUT_ID;

@Component
public class CounterpartyFactory {

    private final RevolutCounterpartyService revolutCounterpartyService;
    private final DNBCounterpartyService dnbCounterpartyService;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public CounterpartyFactory(RevolutCounterpartyService revolutCounterpartyService,
                               DNBCounterpartyService dnbCounterpartyService,
                               ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.revolutCounterpartyService = revolutCounterpartyService;
        this.dnbCounterpartyService = dnbCounterpartyService;
        this.exceptionBuilder = exceptionBuilder;
    }

    public CounterpartyService getService(String bank) {

        switch (bank) {
            case REVOLUT_ID:
                return revolutCounterpartyService;
            case DNB_ID:
                return dnbCounterpartyService;
            default:
                throw exceptionBuilder.getWrongBankException400(bank);
        }
    }
}
