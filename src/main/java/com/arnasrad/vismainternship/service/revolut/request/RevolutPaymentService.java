package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.model.revolut.payment.Payment;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.request.PaymentService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RevolutPaymentService implements PaymentService {

    @Value("${revolut.endpoint.payment}")
    private String paymentEndpoint;

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final JsonMapper jsonMapper;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public RevolutPaymentService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService, JsonMapper jsonMapper, ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.jsonMapper = jsonMapper;
        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public Payment createPayment(CreatePaymentRequestBody body) {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(paymentEndpoint,
                revolutRequestBuilderService.getPaymentRequest(body), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("create-payment"));

        return jsonMapper.getObjectFromString(jsonResponse, Payment.class);
    }
}
