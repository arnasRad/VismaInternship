package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DNBCustomerServiceTest {

    @Value("${dnb.openbanking.endpoint.customers}")
    private String customersEndpoint;

    @Value("${dnb.openbanking.endpoint.customer-info}")
    private String customerInfoEndpoint;

    @Value("${dnb.openbanking.endpoint.current-customer-info}")
    private String currentCustomerInfoEndpoint;

    @InjectMocks
    private DNBCustomerService dnbCustomerService;

    @Mock
    private RestTemplate restTemplate;

}