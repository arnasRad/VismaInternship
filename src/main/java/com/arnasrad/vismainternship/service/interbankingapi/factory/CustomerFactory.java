package com.arnasrad.vismainternship.service.interbankingapi.factory;

import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBCustomerService;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.CustomerService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.arnasrad.vismainternship.model.enums.BankId.DNB_ID;
import static com.arnasrad.vismainternship.model.enums.BankId.REVOLUT_ID;

@Component
public class CustomerFactory {

    private final RevolutCustomerService revolutCustomerService;
    private final DNBCustomerService dnbCustomerService;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public CustomerFactory(RevolutCustomerService revolutCustomerService, DNBCustomerService dnbCustomerService,
                           ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.revolutCustomerService = revolutCustomerService;
        this.dnbCustomerService = dnbCustomerService;
        this.exceptionBuilder = exceptionBuilder;
    }

    public CustomerService getService(String bank) {

        switch (bank) {
            case REVOLUT_ID:
                return revolutCustomerService;
            case DNB_ID:
                return dnbCustomerService;
            default:
                throw exceptionBuilder.getWrongBankException400();
        }
    }
}
