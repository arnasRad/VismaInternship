package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.model.Payment;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.RequestMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("interbanking-payment-controller")
public class PaymentController {

    private final OptionalValueProcessor optionalValueProcessor;
    private final RequestMappingService requestMappingService;

    @Autowired
    public PaymentController(OptionalValueProcessor optionalValueProcessor, RequestMappingService requestMappingService) {

        this.optionalValueProcessor = optionalValueProcessor;
        this.requestMappingService = requestMappingService;
    }

    @PostMapping("/interbanking/create-payment")
    public Map<String, Payment> createPayment(@RequestBody CreatePaymentRequestBody body, String bank) {

        return requestMappingService.mapPaymentRequest(body, optionalValueProcessor.getRequestParameterValue(
                "bank", bank));
    }
}
