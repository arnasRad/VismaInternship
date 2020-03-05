package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.mapper.revolut.RevolutPaymentMapper;
import com.arnasrad.vismainternship.mapper.revolut.RevolutPaymentRequestMapper;
import com.arnasrad.vismainternship.model.dto.PaymentDto;
import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentRequestDto;
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

import java.util.UUID;

@Service
public class RevolutPaymentService implements PaymentService {

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final RevolutTransactionService revolutTransactionService;
    private final PaymentRepository paymentRepository;
    private final RevolutPaymentMapper revolutPaymentMapper;
    private final RevolutPaymentRequestMapper revolutPaymentRequestMapper;
    @Value("${revolut.endpoint.payment}")
    private String paymentEndpoint;

    public RevolutPaymentService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService,
                                 RevolutTransactionService revolutTransactionService,
                                 PaymentRepository paymentRepository, RevolutPaymentMapper revolutPaymentMapper,
                                 RevolutPaymentRequestMapper revolutPaymentRequestMapper) {
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.revolutTransactionService = revolutTransactionService;
        this.paymentRepository = paymentRepository;
        this.revolutPaymentMapper = revolutPaymentMapper;
        this.revolutPaymentRequestMapper = revolutPaymentRequestMapper;
    }

    @Override
    public PaymentDto createPayment(PaymentRequestDto body) {
        RevolutPaymentRequestDto revolutPaymentRequestDto =
                revolutPaymentRequestMapper.mapToRevolutPaymentRequestDto(body);

        revolutPaymentRequestDto.setRequestId(UUID.randomUUID().toString());

        HttpEntity<String> authorizedHttpEntity =
                revolutRequestBuilderService.getPaymentRequest(revolutPaymentRequestDto);

        ResponseEntity<RevolutPaymentDto> responseEntity = restTemplate.postForEntity(paymentEndpoint,
                authorizedHttpEntity, RevolutPaymentDto.class);

        RevolutPaymentDto payment = responseEntity.getBody();
        Payment revolutPayment = revolutPaymentMapper.mapToPaymentEntity(payment);
        paymentRepository.save(revolutPayment);
//        revolutTransactionService.saveTransaction(payment.getId());

        return revolutPaymentMapper.mapToPaymentDto(payment);
    }

    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }

    public void setPaymentEndpoint(String paymentEndpoint) {
        this.paymentEndpoint = paymentEndpoint;
    }
}
