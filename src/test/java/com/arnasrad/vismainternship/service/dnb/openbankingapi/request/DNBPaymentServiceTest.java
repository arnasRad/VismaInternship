package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DNBPaymentServiceTest {

    @InjectMocks
    private DNBPaymentService dnbPaymentService;

    @Mock
    private RestTemplate restTemplate;

}