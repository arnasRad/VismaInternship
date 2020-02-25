package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.entity.revolut.payment.RevolutPayment;
import com.arnasrad.vismainternship.service.revolut.request.RevolutPaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final RevolutPaymentService revolutPaymentService;

    public PaymentController(RevolutPaymentService revolutPaymentService) {
        this.revolutPaymentService = revolutPaymentService;
    }

    @PostMapping(value = "/revolut/create-payment", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public RevolutPayment createPayment(@RequestBody String body) {
        return revolutPaymentService.createPayment(body);
    }
}
