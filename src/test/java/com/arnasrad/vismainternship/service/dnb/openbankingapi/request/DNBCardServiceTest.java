package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DNBCardServiceTest {

    @Value("${dnb.openbanking.endpoint.cards}")
    private String cardsEndpoint;

    @InjectMocks
    private DNBCardService dnbCardService;

    @Mock
    private RestTemplate restTemplate;

}