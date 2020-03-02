package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.mapper.PaymentMapper;
import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDto;
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
    private final PaymentMapper revolutPaymentMapper;
    @Value("${revolut.endpoint.payment}")
    private String paymentEndpoint;

    public RevolutPaymentService(RestTemplate restTemplate,
                                 RevolutRequestBuilderService revolutRequestBuilderService,
                                 RevolutTransactionService revolutTransactionService,
                                 PaymentRepository paymentRepository, PaymentMapper revolutPaymentMapper) {
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.revolutTransactionService = revolutTransactionService;
        this.paymentRepository = paymentRepository;
        this.revolutPaymentMapper = revolutPaymentMapper;
    }

    @Override
    public RevolutPaymentDto createPayment(PaymentRequestDto body) {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getPaymentRequest(body);

        ResponseEntity<RevolutPaymentDto> responseEntity = restTemplate.postForEntity(paymentEndpoint,
                authorizedHttpEntity, RevolutPaymentDto.class);

        RevolutPaymentDto payment = responseEntity.getBody();
        Payment revolutPayment = revolutPaymentMapper.mapToPaymentEntity(payment);
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
