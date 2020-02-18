package com.arnasrad.vismainternship.service.interbankingapi.factory;

import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBTransferService;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.TransferService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.arnasrad.vismainternship.model.enums.BankId.DNB_ID;
import static com.arnasrad.vismainternship.model.enums.BankId.REVOLUT_ID;

@Component
public class TransferFactory {

    private final RevolutTransferService revolutTransferService;
    private final DNBTransferService dnbTransferService;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public TransferFactory(RevolutTransferService revolutTransferService, DNBTransferService dnbTransferService,
                           ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.revolutTransferService = revolutTransferService;
        this.dnbTransferService = dnbTransferService;
        this.exceptionBuilder = exceptionBuilder;
    }

    public TransferService getService(String bank) {

        switch (bank) {
            case REVOLUT_ID:
                return revolutTransferService;
            case DNB_ID:
                return dnbTransferService;
            default:
                throw exceptionBuilder.getWrongBankException400();
        }
    }
}
