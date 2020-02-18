package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutPayment;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutTransaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.request.PaymentService;
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

    @Autowired
    public RevolutPaymentService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService, JsonMapper jsonMapper) {

        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public RevolutPayment createPayment(CreatePaymentRequestBody body) throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(paymentEndpoint,
                revolutRequestBuilderService.getPaymentRequest(body), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST, "createPayment")));

        return jsonMapper.getObjectFromString(jsonResponse, RevolutPayment.class);
    }

    @Override
    public Transaction getTransaction(String id) throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(transactionEndpoint.concat(id),
                HttpMethod.GET, revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST,
                        "getTransaction")));

        return jsonMapper.getObjectFromString(jsonResponse, RevolutTransaction.class);
    }

    @Override
    public List<? extends Transaction> getTransactions(String counterparty, Date from, Date to, Integer count) throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(transactionsEndpoint, HttpMethod.GET,
                revolutRequestBuilderService.getTransactionsRequest(counterparty, from, to, count), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST,
                        "getTransactions")));

        return jsonMapper.getObjectListFromString(jsonResponse, RevolutTransaction.class);
    }

    @Override
    public String getBankId() {

        return BankId.REVOLUT_ID.getBank();
    }
}
