package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.model.Payment;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.factory.PaymentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("interbanking-payment-controller")
public class PaymentController {

    private final OptionalValueProcessor optionalValueProcessor;
    private final PaymentFactory paymentFactory;

    @Autowired
    public PaymentController(OptionalValueProcessor optionalValueProcessor, PaymentFactory paymentFactory) {
        this.optionalValueProcessor = optionalValueProcessor;
        this.paymentFactory = paymentFactory;
    }

    @PostMapping("/interbanking/create-payment")
    public Payment createPayment(@RequestBody CreatePaymentRequestBody body, String bank) {

        return paymentFactory.getService(optionalValueProcessor.getRequestParameterValue("bank", bank)).createPayment(body);
    }
}
