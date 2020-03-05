package com.arnasrad.vismainternship.service.revolut.request.unit;

import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutPaymentService;
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
class RevolutPaymentDtoServiceTest {
    private String paymentEndpoint;

    @InjectMocks
    private RevolutPaymentService revolutPaymentService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private RevolutRequestBuilderService revolutRequestBuilderService;

    @Mock
    private HttpEntity<String> stringHttpEntityMock;

    @Mock
    private ResponseEntity<String> stringResponseEntityMock;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(RevolutPaymentDtoServiceTest.class);
        this.paymentEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/pay";
        this.revolutPaymentService.setPaymentEndpoint(paymentEndpoint);
    }

}