package com.arnasrad.vismainternship.revolut.controller;

import com.arnasrad.vismainternship.revolut.model.payment.Payment;
import com.arnasrad.vismainternship.revolut.model.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.revolut.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    @Qualifier("revolut-request-service")
    private RequestService requestService;

    @PostMapping(value="/revolut/create-payment", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public Payment createPayment(@RequestBody CreatePaymentRequestBody body) {

        return requestService.createPayment(body);
    }
}
