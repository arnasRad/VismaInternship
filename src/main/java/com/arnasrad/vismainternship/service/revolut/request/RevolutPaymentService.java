package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutPayment;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutTransaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.persistence.payment.PaymentRepository;
import com.arnasrad.vismainternship.persistence.payment.TransactionLegsRepository;
import com.arnasrad.vismainternship.persistence.payment.TransactionRepository;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
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
    private final JsonMapperService jsonMapperService;
    private final PaymentRepository paymentRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public RevolutPaymentService(RestTemplate restTemplate,
                                 RevolutRequestBuilderService revolutRequestBuilderService,
                                 JsonMapperService jsonMapperService, PaymentRepository paymentRepository,
                                 TransactionRepository transactionRepository) {

        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.jsonMapperService = jsonMapperService;
        this.paymentRepository = paymentRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public RevolutPayment createPayment(CreatePaymentRequestBody body) throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(paymentEndpoint,
                revolutRequestBuilderService.getPaymentRequest(body), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST, "createPayment")));

        RevolutPayment payment = jsonMapperService.getObjectFromString(jsonResponse, RevolutPayment.class);
        RevolutTransaction transaction = (RevolutTransaction) getTransaction(payment.getId());

        paymentRepository.save(payment);
        transactionRepository.save(transaction);
        return payment;
    }

    @Override
    public Transaction getTransaction(String id) throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(transactionEndpoint.concat(id),
                HttpMethod.GET, revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST,
                        "getTransaction")));

        return jsonMapperService.getObjectFromString(jsonResponse, RevolutTransaction.class);
    }

    @Override
    public List<? extends Transaction> getTransactions(String counterparty, Date from, Date to, Integer count) throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(transactionsEndpoint, HttpMethod.GET,
                revolutRequestBuilderService.getTransactionsRequest(counterparty, from, to, count), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST,
                        "getTransactions")));

        return jsonMapperService.getObjectListFromString(jsonResponse, RevolutTransaction.class);
    }

    @Override
    public String getBankId() {

        return BankId.REVOLUT_ID.getBank();
    }
}
