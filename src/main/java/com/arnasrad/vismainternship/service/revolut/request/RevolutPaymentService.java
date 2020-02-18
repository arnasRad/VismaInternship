package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.model.interbankingapi.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutPayment;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutTransaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.PaymentService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RevolutPaymentService implements PaymentService {

    @Value("${revolut.endpoint.payment}")
    private String paymentEndpoint;

    @Value("${revolut.endpoint.transaction}")
    private String transactionEndpoint;

    @Value("${revolut.endpoint.transactions}")
    private String transactionsEndpoint;

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
    public RevolutPayment createPayment(CreatePaymentRequestBody body) {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(paymentEndpoint,
                revolutRequestBuilderService.getPaymentRequest(body), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("create-payment"));

        return jsonMapper.getObjectFromString(jsonResponse, RevolutPayment.class);
    }

    @Override
    public Transaction getTransaction(String id) {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(transactionEndpoint.concat(id),
                HttpMethod.GET, revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-transaction"));

        return jsonMapper.getObjectFromString(jsonResponse, RevolutTransaction.class);
    }

    @Override
    public List<? extends Transaction> getTransactions(String counterparty, Date from, Date to, Integer count) {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(transactionsEndpoint, HttpMethod.GET,
                revolutRequestBuilderService.getTransactionsRequest(counterparty, from, to, count), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-transactions"));

        return jsonMapper.getObjectListFromString(jsonResponse, RevolutTransaction.class);
    }
}
