package com.arnasrad.vismainternship.service.interbankingapi.factory;

import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBCardService;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.CardService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.arnasrad.vismainternship.model.enums.BankId.DNB_ID;
import static com.arnasrad.vismainternship.model.enums.BankId.REVOLUT_ID;

@Component
public class CardFactory {

    private final RevolutCardService revolutCardService;
    private final DNBCardService dnbCardService;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public CardFactory(RevolutCardService revolutCardService, DNBCardService dnbCardService,
                       ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.revolutCardService = revolutCardService;
        this.dnbCardService = dnbCardService;
        this.exceptionBuilder = exceptionBuilder;
    }

    public CardService getService(String bank) {

        switch (bank) {
            case REVOLUT_ID:
                return revolutCardService;
            case DNB_ID:
                return dnbCardService;
            default:
                throw exceptionBuilder.getWrongBankException400();
        }
    }
}
