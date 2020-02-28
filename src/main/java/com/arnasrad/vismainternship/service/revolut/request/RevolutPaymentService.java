package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDTO;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDTO;
import com.arnasrad.vismainternship.model.entity.payment.Payment;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.persistence.payment.PaymentRepository;
import com.arnasrad.vismainternship.service.request.PaymentService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
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
    private final RevolutPaymentMapper revolutPaymentMapper;
    @Value("${revolut.endpoint.payment}")
    private String paymentEndpoint;

    public RevolutPaymentService(RestTemplate restTemplate,
                                 RevolutRequestBuilderService revolutRequestBuilderService,
                                 RevolutTransactionService revolutTransactionService,
                                 PaymentRepository paymentRepository, RevolutPaymentMapper revolutPaymentMapper) {
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.revolutTransactionService = revolutTransactionService;
        this.paymentRepository = paymentRepository;
        this.revolutPaymentMapper = revolutPaymentMapper;
    }

    @Override
    public RevolutPaymentDTO createPayment(PaymentRequestDTO body) {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getPaymentRequest(body);

        ResponseEntity<RevolutPaymentDTO> responseEntity = restTemplate.postForEntity(paymentEndpoint,
                authorizedHttpEntity, RevolutPaymentDTO.class);

        RevolutPaymentDTO payment = responseEntity.getBody();
        Payment revolutPayment = revolutPaymentMapper.mapToEntity(payment);
        paymentRepository.save(revolutPayment);
        revolutTransactionService.saveTransaction(payment.getId());

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
