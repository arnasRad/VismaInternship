package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.interbankingapi.payment.Payment;
import com.arnasrad.vismainternship.model.interbankingapi.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DNBPaymentService implements PaymentService {

    @Value("${constant.dnb-id-uppercase}")
    private String dnbId;

    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public DNBPaymentService(ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public Payment createPayment(CreatePaymentRequestBody body) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "createPayment");
    }

    @Override
    public Transaction getTransaction(String id) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "getTransaction");
    }

    @Override
    public List<? extends Transaction> getTransactions(String counterparty, Date from, Date to, Integer count) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "getTransactions");
    }
}
