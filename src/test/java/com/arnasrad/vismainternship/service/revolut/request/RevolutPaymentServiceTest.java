package com.arnasrad.vismainternship.service.revolut.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RevolutPaymentServiceTest {

    @Value("${revolut.endpoint.payment}")
    private String paymentEndpoint;

    @Value("${revolut.endpoint.transaction}")
    private String transactionEndpoint;

    @Value("${revolut.endpoint.transactions}")
    private String transactionsEndpoint;

    @InjectMocks
    private RevolutPaymentService revolutPaymentService;

    @Mock
    private RestTemplate restTemplate;

}