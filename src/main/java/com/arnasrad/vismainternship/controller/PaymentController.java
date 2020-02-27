package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDTO;
import com.arnasrad.vismainternship.service.jms.PaymentProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("interbanking-payment-controller")
public class PaymentController {

    private final PaymentProducer paymentProducer;

    public PaymentController(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @PostMapping("/interbanking/create-payment")
    public String createPayment(@RequestBody PaymentRequestDTO body, @RequestParam String bank) {
        paymentProducer.send(bank, body);
        return "Payment request sent to ".concat(bank).concat("!");
    }
}
