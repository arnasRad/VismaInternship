package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.entity.revolut.payment.RevolutPayment;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.persistence.payment.PaymentRepository;
import com.arnasrad.vismainternship.service.request.PaymentService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RevolutPaymentService implements PaymentService {

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final RevolutTransactionService revolutTransactionService;
    private final PaymentRepository paymentRepository;
    @Value("${revolut.endpoint.payment}")
    private String paymentEndpoint;

    public RevolutPaymentService(RestTemplate restTemplate,
                                 RevolutRequestBuilderService revolutRequestBuilderService,
                                 RevolutTransactionService revolutTransactionService,
                                 PaymentRepository paymentRepository) {
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.revolutTransactionService = revolutTransactionService;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public RevolutPayment createPayment(String body) {
        JSONObject jsonObject = new JSONObject(body);
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getPaymentRequest(jsonObject);

        ResponseEntity<RevolutPayment> responseEntity = restTemplate.postForEntity(paymentEndpoint, authorizedHttpEntity,
                RevolutPayment.class);

        RevolutPayment payment = responseEntity.getBody();
        paymentRepository.save(payment);
        revolutTransactionService.saveTransaction(payment.getPaymentId());

        return payment;
    }

    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }

    public void setPaymentEndpoint(String paymentEndpoint) {
        this.paymentEndpoint = paymentEndpoint;
    }
}
