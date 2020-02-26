package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.dto.payment.PaymentDTO;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.PaymentServiceFactory;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("interbanking-payment-controller")
public class PaymentController {

    private final PaymentServiceFactory paymentServiceFactory;

    public PaymentController(PaymentServiceFactory paymentServiceFactory) {
        this.paymentServiceFactory = paymentServiceFactory;
    }

    @PostMapping("/interbanking/create-payment")
    public PaymentDTO createPayment(@RequestBody String body, @RequestParam String bank)
            throws NoSuchFunctionalityException {
        PaymentService service = paymentServiceFactory.getService(bank);
        return service.createPayment(body);
    }
}
