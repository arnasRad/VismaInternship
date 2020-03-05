package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentRequestDto;
import com.arnasrad.vismainternship.service.jms.PaymentProducer;
import org.springframework.web.bind.annotation.*;

@RestController("interbanking-payment-controller")
public class PaymentController {

    private final PaymentProducer paymentProducer;

    public PaymentController(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @PostMapping("/interbanking/create-payment")
    public String createPayment(@RequestBody PaymentRequestDto body) {
        paymentProducer.send(body);
        return "Payment request sent to ".concat(body.getBankName()).concat("!");
    }
}
