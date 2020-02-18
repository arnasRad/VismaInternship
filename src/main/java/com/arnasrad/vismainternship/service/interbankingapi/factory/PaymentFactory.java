package com.arnasrad.vismainternship.service.interbankingapi.factory;

import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBPaymentService;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.PaymentService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.arnasrad.vismainternship.model.enums.BankId.DNB_ID;
import static com.arnasrad.vismainternship.model.enums.BankId.REVOLUT_ID;

@Component
public class PaymentFactory {

    private final RevolutPaymentService revolutPaymentService;
    private final DNBPaymentService dnbPaymentService;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public PaymentFactory(RevolutPaymentService revolutPaymentService, DNBPaymentService dnbPaymentService,
                          ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.revolutPaymentService = revolutPaymentService;
        this.dnbPaymentService = dnbPaymentService;
        this.exceptionBuilder = exceptionBuilder;
    }

    public PaymentService getService(String bank) {

        switch (bank) {
            case REVOLUT_ID:
                return revolutPaymentService;
            case DNB_ID:
                return dnbPaymentService;
            default:
                throw exceptionBuilder.getWrongBankException400();
        }
    }
}