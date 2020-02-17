package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.revolut.payment.Payment;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
}
