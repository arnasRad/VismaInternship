package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutPayment;
import com.arnasrad.vismainternship.model.revolut.payment.RevolutTransaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.persistence.payment.PaymentRepository;
import com.arnasrad.vismainternship.persistence.payment.TransactionRepository;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.request.PaymentService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

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
    public RevolutPayment createPayment(CreatePaymentRequestBody body) {

        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getPaymentRequest(body);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(paymentEndpoint, authorizedHttpEntity,
                String.class);

        String jsonResponse = responseEntity.getBody();

        RevolutPayment payment = jsonMapperService.getObjectFromString(jsonResponse, RevolutPayment.class);
        RevolutTransaction transaction = (RevolutTransaction) getTransaction(payment.getId());

        paymentRepository.save(payment);
        transactionRepository.save(transaction);
        return payment;
    }

    @Override
    public Transaction getTransaction(String id) {

        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(transactionEndpoint.concat(id), HttpMethod.GET
                , authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectFromString(jsonResponse, RevolutTransaction.class);
    }

    @Override
    public List<? extends Transaction> getTransactions(String counterparty, Date from, Date to, Integer count) {

        HttpEntity<MultiValueMap<String, String>> authorizedHttpEntity =
                revolutRequestBuilderService.getTransactionsRequest(counterparty, from, to, count);

        ResponseEntity<String> responseEntity = restTemplate.exchange(transactionsEndpoint, HttpMethod.GET,
                authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectListFromString(jsonResponse, RevolutTransaction.class);
    }

    @Override
    public String getBankId() {

        return BankId.REVOLUT_ID.getBank();
    }
}
