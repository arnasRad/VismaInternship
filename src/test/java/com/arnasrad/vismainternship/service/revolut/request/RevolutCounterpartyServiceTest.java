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
class RevolutCounterpartyServiceTest {

    private String counterpartyEndpoint;
    private String counterpartiesEndpoint;

    @InjectMocks
    private RevolutCounterpartyService revolutCounterpartyService;

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

        MockitoAnnotations.initMocks(RevolutCounterpartyServiceTest.class);
        this.counterpartyEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/counterparty";
        this.counterpartiesEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/counterparties";
        this.revolutCounterpartyService.setCounterpartyEndpoint(counterpartyEndpoint);
        this.revolutCounterpartyService.setCounterpartiesEndpoint(counterpartiesEndpoint);
    }

}