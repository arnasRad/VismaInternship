package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@ExtendWith(MockitoExtension.class)
class RevolutPaymentServiceTest {

    private String paymentEndpoint;
    private String transactionEndpoint;
    private String transactionsEndpoint;

    @InjectMocks
    private RevolutPaymentService revolutPaymentService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private RevolutRequestBuilderService revolutRequestBuilderService;

    @Mock
    private JsonMapperService jsonMapperService;

    @Mock
    private HttpEntity<String> stringHttpEntityMock;

    @Mock
    private ResponseEntity<String> stringResponseEntityMock;

    @BeforeEach
    void init() {

        MockitoAnnotations.initMocks(RevolutPaymentServiceTest.class);
        this.paymentEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/pay";
        this.transactionEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/transaction/";
        this.transactionsEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/transactions";
        this.revolutPaymentService.setPaymentEndpoint(paymentEndpoint);
        this.revolutPaymentService.setTransactionEndpoint(transactionEndpoint);
        this.revolutPaymentService.setTransactionsEndpoint(transactionsEndpoint);
    }

}