package com.arnasrad.vismainternship.service.revolut.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RevolutCounterpartyServiceTest {

    @Value("${revolut.endpoint.counterparty}")
    private String counterpartyEndpoint;

    @Value("${revolut.endpoint.counterparties}")
    private String counterpartiesEndpoint;

    @InjectMocks
    private RevolutCounterpartyService revolutAccountService;

    @Mock
    private RestTemplate restTemplate;

}