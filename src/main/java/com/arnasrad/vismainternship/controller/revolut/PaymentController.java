package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.revolut.payment.Payment;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.revolut.RevolutRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final RevolutRequestService revolutRequestService;

    @Autowired
    public PaymentController(RevolutRequestService revolutRequestService) {
        this.revolutRequestService = revolutRequestService;
    }

    @PostMapping(value = "/revolut/create-payment", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public Payment createPayment(@RequestBody CreatePaymentRequestBody body) {

        return revolutRequestService.createPayment(body);
    }
}
